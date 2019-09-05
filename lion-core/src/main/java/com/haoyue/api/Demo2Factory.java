package com.haoyue.api;

import com.haoyue.api.spi.Demo;
import com.haoyue.api.spi.DemoFactory;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 11:32:39
 * @describe:
 **/
public class Demo2Factory implements DemoFactory {
    @Override
    public Demo get() {
        System.out.println(123123);
        return new Demo2();
    }
}