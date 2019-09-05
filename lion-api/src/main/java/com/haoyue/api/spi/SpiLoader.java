package com.haoyue.api.spi;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiehao
 * @version 1.0
 * @date 创建时间：2019年09月04日 10:28:36
 * @describe: SPI加载类
 **/
public final class SpiLoader {

    private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();

    public static void clear() {
        CACHE.clear();
    }

    public static <T> T load(Class<T> clz) {
        return load(clz, null);
    }

    public static <T> T load(Class<T> clz, String name) {
        String key = clz.getName();
        Object o = CACHE.get(key);
        if (o == null) {
            T t = load0(clz, name);
            if (t != null) {
                CACHE.put(key, t);
                return t;
            }
        } else if (clz.isInstance(o)) {
            return (T) o;
        }

        return load0(clz, name);
    }

    private static <T> T load0(Class<T> clz, String name) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clz);
        T t = filterByName(serviceLoader, name);
        if (t == null) {
            serviceLoader = ServiceLoader.load(clz, SpiLoader.class.getClassLoader());
            t = filterByName(serviceLoader, name);
        }

        if (t != null) {
            return t;
        } else {
            throw new IllegalStateException("Cannot find META-INF/services/" + clz.getName() + " on classpath");
        }
    }

    private static <T> T filterByName(ServiceLoader<T> serviceLoader, String name) {
        Iterator<T> iterator = serviceLoader.iterator();
        if (name == null) {
            List<T> list = new ArrayList<>(2);
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            if (list.size() > 1 ) {
                list.sort((o1, o2) -> {
                    Spi s1 = o1.getClass().getAnnotation(Spi.class);
                    Spi s2 = o2.getClass().getAnnotation(Spi.class);
                    int order1 = s1 == null ? 0 : s1.order();
                    int order2 = s2 == null ? 0 : s2.order();
                    return order1 - order2;
                });
            }
            if (list.size() > 0) {
                return list.get(0);
            }
        } else {
            while (iterator.hasNext()) {
                T t = iterator.next();
                if (name.equals(t.getClass().getName())
                || name.equals(t.getClass().getSimpleName())) {
                    return t;
                }
            }
        }
        return null;
    }
}