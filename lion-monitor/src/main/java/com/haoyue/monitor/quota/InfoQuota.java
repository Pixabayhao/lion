
package com.haoyue.monitor.quota;

public interface InfoQuota extends MonitorQuota {

    String pid();

    double load();
}
