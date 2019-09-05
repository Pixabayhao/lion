

package com.haoyue.api.spi.push;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

/**
 *
 *
 */
public interface PushListenerFactory<M extends IPushMessage> extends Factory<PushListener<M>> {

    @SuppressWarnings("unchecked")
    static <M extends IPushMessage> PushListener<M> create() {
        return (PushListener<M>) SpiLoader.load(PushListenerFactory.class).get();
    }
}
