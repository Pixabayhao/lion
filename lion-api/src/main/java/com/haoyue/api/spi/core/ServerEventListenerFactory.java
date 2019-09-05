
package com.haoyue.api.spi.core;


import com.haoyue.api.Factory;
import com.haoyue.api.common.ServerEventListener;
import com.haoyue.api.spi.SpiLoader;

public interface ServerEventListenerFactory extends Factory<ServerEventListener> {
    static ServerEventListener create() {
        return SpiLoader.load(ServerEventListenerFactory.class).get();
    }
}
