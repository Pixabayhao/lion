
package com.haoyue.api.spi.core;


import com.haoyue.api.Factory;
import com.haoyue.api.connection.Cipher;
import com.haoyue.api.spi.SpiLoader;

public interface RsaCipherFactory extends Factory<Cipher> {
    static Cipher create() {
        return SpiLoader.load(RsaCipherFactory.class).get();
    }
}
