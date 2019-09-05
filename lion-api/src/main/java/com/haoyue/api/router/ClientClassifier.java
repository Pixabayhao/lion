
package com.haoyue.api.router;


import com.haoyue.api.spi.router.ClientClassifierFactory;

public interface ClientClassifier {
    ClientClassifier I = ClientClassifierFactory.create();

    int getClientType(String osName);
}
