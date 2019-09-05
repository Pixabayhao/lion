
package com.haoyue.api.spi.common;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;

import javax.imageio.spi.ServiceRegistry;

public interface ServiceRegistryFactory extends Factory<ServiceRegistry> {
    static ServiceRegistry create() {
        return SpiLoader.load(ServiceRegistryFactory.class).get();
    }
}
