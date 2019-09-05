
package com.haoyue.api.spi.common;


import com.haoyue.api.Factory;
import com.haoyue.api.spi.SpiLoader;
import com.haoyue.api.srd.ServiceDiscovery;

public interface ServiceDiscoveryFactory extends Factory<ServiceDiscovery> {
    static ServiceDiscovery create() {
        return SpiLoader.load(ServiceDiscoveryFactory.class).get();
    }
}
