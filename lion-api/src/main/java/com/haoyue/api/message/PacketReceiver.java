
package com.haoyue.api.message;

import com.haoyue.api.connection.Connection;
import com.haoyue.api.protocol.Packet;


public interface PacketReceiver {
    void onReceive(Packet packet, Connection connection);
}
