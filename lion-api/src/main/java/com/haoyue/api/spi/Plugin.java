
package com.haoyue.api.spi;


import com.haoyue.api.LionContext;

/**
 *
 *
 *
 */
public interface Plugin {

    default void init(LionContext context) {

    }

    default void destroy() {

    }
}
