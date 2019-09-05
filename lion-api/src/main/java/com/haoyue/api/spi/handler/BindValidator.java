
package com.haoyue.api.spi.handler;


import com.haoyue.api.spi.Plugin;

public interface BindValidator extends Plugin {
    boolean validate(String userId, String data);
}
