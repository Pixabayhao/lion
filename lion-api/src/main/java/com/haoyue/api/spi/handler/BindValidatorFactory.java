
package com.haoyue.api.spi.handler;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

public interface BindValidatorFactory extends Factory<BindValidator> {
    static BindValidator create() {
        return SpiLoader.load(BindValidatorFactory.class).get();
    }
}
