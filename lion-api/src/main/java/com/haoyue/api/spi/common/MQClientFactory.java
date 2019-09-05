
package com.haoyue.api.spi.common;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

public interface MQClientFactory extends Factory<MQClient> {

    static MQClient create() {
        return SpiLoader.load(MQClientFactory.class).get();
    }
}
