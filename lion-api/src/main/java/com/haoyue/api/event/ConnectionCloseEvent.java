

package com.haoyue.api.event;


import com.haoyue.api.connection.Connection;

public final class ConnectionCloseEvent implements Event {
    public final Connection connection;


    public ConnectionCloseEvent(Connection connection) {
        this.connection = connection;
    }
}
