package com.haoyue.api;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 11:31:34
 * @describe:
 **/

import java.util.function.Supplier;

/**
 */
@FunctionalInterface
public interface Factory<T> extends Supplier<T> {
}