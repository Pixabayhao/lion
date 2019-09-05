
package com.haoyue.tools.event;

public abstract class EventConsumer {

    public EventConsumer() {
        EventBus.register(this);
    }

}
