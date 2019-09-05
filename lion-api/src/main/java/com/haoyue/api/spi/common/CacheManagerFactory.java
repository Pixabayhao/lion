
package com.haoyue.api.spi.common;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

public interface CacheManagerFactory extends Factory<CacheManager> {
    static CacheManager create() {
        return SpiLoader.load(CacheManagerFactory.class).get();
    }
}
