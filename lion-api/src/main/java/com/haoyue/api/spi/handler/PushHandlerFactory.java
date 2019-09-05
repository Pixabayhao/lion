
package com.haoyue.api.spi.handler;


import com.haoyue.api.Factory;
import com.haoyue.api.message.MessageHandler;
import com.haoyue.api.spi.SpiLoader;

/**
 *
 */
public interface PushHandlerFactory extends Factory<MessageHandler> {
    static MessageHandler create() {
        return SpiLoader.load(PushHandlerFactory.class).get();
    }
}
