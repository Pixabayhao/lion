

package com.haoyue.api.event;


import com.haoyue.api.connection.Connection;

public final class ConnectionConnectEvent implements Event {
    public final Connection connection;

    public ConnectionConnectEvent(Connection connection) {
        this.connection = connection;
    }
}
