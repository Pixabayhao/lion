
package com.haoyue.api.srd;


import com.haoyue.api.service.Service;

/**
 *
 *
 */
public interface ServiceRegistry extends Service {

    void register(ServiceNode node);

    void deregister(ServiceNode node);
}
