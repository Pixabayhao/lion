
package com.haoyue.api.spi;

import com.haoyue.api.service.Service;

/**
 *
 */
public interface DnsMappingManager extends Service {

    static DnsMappingManager create() {
        return SpiLoader.load(DnsMappingManager.class);
    }

    DnsMapping lookup(String origin);
}
