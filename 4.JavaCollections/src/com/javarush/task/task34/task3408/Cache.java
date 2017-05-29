package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V v = cache.get(key);
        if (v != null) {
            return v;
        } else {
            Class<?> keyClass = key.getClass();
            Constructor<V> constructor = clazz.getConstructor(keyClass);
            v = constructor.newInstance(key);
            cache.put(key, v);
            return cache.get(key);
        }
    }

    public boolean put(V obj) {
        Class c = obj.getClass();
        K o;
        try {
            Method method = c.getDeclaredMethod("getKey");
            method.setAccessible(true);
            o = (K) method.invoke(obj);
        } catch (Exception e) {
            return false;
        }
        cache.put(o, obj);
        return true;
    }

    public int size() {
        return cache.size();
    }
}
