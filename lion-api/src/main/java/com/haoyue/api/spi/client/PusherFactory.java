
package com.haoyue.api.spi.client;

import com.haoyue.api.Factory;
import com.haoyue.api.push.PushSender;
import com.haoyue.api.spi.SpiLoader;


public interface PusherFactory extends Factory<PushSender> {
    static PushSender create() {
        return SpiLoader.load(PusherFactory.class).get();
    }
}
