
package com.haoyue.monitor.service;


import com.haoyue.api.common.Monitor;
import com.haoyue.api.service.BaseService;
import com.haoyue.api.service.Listener;
import com.haoyue.monitor.data.MonitorResult;
import com.haoyue.monitor.data.ResultCollector;
import com.haoyue.tools.Utils;
import com.haoyue.tools.common.JVMUtil;
import com.haoyue.tools.config.CC;
import com.haoyue.tools.log.Logs;
import com.haoyue.tools.thread.ThreadNames;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class MonitorService extends BaseService implements Monitor, Runnable {

    private static final int FIRST_DUMP_JSTACK_LOAD_AVG = 2,
            SECOND_DUMP_JSTACK_LOAD_AVG = 4,
            THIRD_DUMP_JSTACK_LOAD_AVG = 6,
            FIRST_DUMP_JMAP_LOAD_AVG = 4;

    private static final String dumpLogDir = CC.lion.monitor.dump_dir;
    private static final boolean dumpEnabled = CC.lion.monitor.dump_stack;
    private static final boolean printLog = CC.lion.monitor.print_log;
    private static final long dumpPeriod = CC.lion.monitor.dump_period.getSeconds();

    private volatile boolean dumpFirstJstack = false;
    private volatile boolean dumpSecondJstack = false;
    private volatile boolean dumpThirdJstack = false;
    private volatile boolean dumpJmap = false;

    private final ResultCollector collector;

    private final ThreadPoolManager threadPoolManager;

    public MonitorService() {
        threadPoolManager = new ThreadPoolManager();
        collector = new ResultCollector(threadPoolManager);
    }

    private Thread thread;

    @Override
    public void run() {
        while (isRunning()) {
            MonitorResult result = collector.collect();

            if (printLog) {
                Logs.MONITOR.info(result.toJson());
            }

            if (dumpEnabled) {
                dump();
            }

            try {
                TimeUnit.SECONDS.sleep(dumpPeriod);
            } catch (InterruptedException e) {
                if (isRunning()) stop();
            }
        }
    }

    @Override
    protected void doStart(Listener listener) throws Throwable {
        if (printLog || dumpEnabled) {
            thread = Utils.newThread(ThreadNames.T_MONITOR, this);
            thread.setDaemon(true);
            thread.start();
        }
        listener.onSuccess();
    }

    @Override
    protected void doStop(Listener listener) throws Throwable {
        if (thread != null && thread.isAlive()) thread.interrupt();
        listener.onSuccess();
    }

    private void dump() {
        double load = collector.getJvmInfo().load();
        if (load > FIRST_DUMP_JSTACK_LOAD_AVG) {
            if (!dumpFirstJstack) {
                dumpFirstJstack = true;
                JVMUtil.dumpJstack(dumpLogDir);
            }
        }

        if (load > SECOND_DUMP_JSTACK_LOAD_AVG) {
            if (!dumpSecondJstack) {
                dumpSecondJstack = true;
                JVMUtil.dumpJmap(dumpLogDir);
            }
        }

        if (load > THIRD_DUMP_JSTACK_LOAD_AVG) {
            if (!dumpThirdJstack) {
                dumpThirdJstack = true;
                JVMUtil.dumpJmap(dumpLogDir);
            }
        }

        if (load > FIRST_DUMP_JMAP_LOAD_AVG) {
            if (!dumpJmap) {
                dumpJmap = true;
                JVMUtil.dumpJmap(dumpLogDir);
            }
        }
    }


    @Override
    public void monitor(String name, Thread thread) {

    }

    @Override
    public void monitor(String name, Executor executor) {
        threadPoolManager.register(name, executor);
    }

    public ThreadPoolManager getThreadPoolManager() {
        return threadPoolManager;
    }

    public static void main(String[] args) {
        new MonitorService().start();
    }
}
