
package com.haoyue.api.spi.common;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

public interface JsonFactory extends Factory<Json> {

    static Json create() {
        return SpiLoader.load(JsonFactory.class).get();
    }
}
