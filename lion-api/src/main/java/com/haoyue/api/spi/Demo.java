package com.haoyue.api.spi;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 11:26:35
 * @describe:
 **/
public interface Demo {
    static Demo create() {
        return SpiLoader.load(Demo.class);
    }
    void test();
}
