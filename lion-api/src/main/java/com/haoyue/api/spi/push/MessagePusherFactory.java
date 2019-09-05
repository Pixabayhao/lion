
package com.haoyue.api.spi.push;

import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

/**
 *
 *
 */
public interface MessagePusherFactory extends Factory<MessagePusher> {

    static MessagePusher create() {
        return SpiLoader.load(MessagePusherFactory.class).get();
    }
}
