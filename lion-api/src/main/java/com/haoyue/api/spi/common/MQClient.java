
package com.haoyue.api.spi.common;


import com.haoyue.api.spi.Plugin;

public interface MQClient extends Plugin {

    void subscribe(String topic, MQMessageReceiver receiver);

    void publish(String topic, Object message);
}
