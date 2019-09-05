package com.haoyue.api.spi;

import com.haoyue.api.Factory;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 11:30:41
 * @describe:
 **/
public interface DemoFactory extends Factory<Demo> {
    static Demo create() {
        return SpiLoader.load(DemoFactory.class).get();
    }
}
