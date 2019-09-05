
package com.haoyue.api.spi.router;

import com.haoyue.api.Factory;
import com.haoyue.api.router.ClientClassifier;
import com.haoyue.api.spi.SpiLoader;

/**
 *
 *
 */
public interface ClientClassifierFactory extends Factory<ClientClassifier> {

    static ClientClassifier create() {
        return SpiLoader.load(ClientClassifierFactory.class).get();
    }
}
