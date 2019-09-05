package com.haoyue.api;

import com.haoyue.api.spi.Demo;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 11:38:18
 * @describe:
 **/
public class Demo2 implements Demo {
    @Override
    public void test() {
        System.out.println(123);
    }

    public static void main(String[] args) {
        Demo.create().test();
    }
}