package com.geekbang.jvm;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("Hello");
        Object obj = aClass.newInstance();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if ("hello".equals(method.getName())) {
                method.invoke(obj);
            }
        }
    }


}
