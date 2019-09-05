package com.haoyue.api.spi;

import java.lang.annotation.*;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 10:30:21
 * @describe:
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Spi {

    /**
     * SPI name
     * @return
     */
    String value() default "";

    /**
     * 排序顺讯
     * @return
     */
    int order() default 0;
}
