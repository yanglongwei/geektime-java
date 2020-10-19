package com.geekbang.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

//    private String filePath;
//
//    public MyClassLoader(ClassLoader parent, String filePath) {
//        this.filePath = filePath;
//    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if ("Hello".equals(name)) {
            String path = "src/main/resources/Hello.xlass";
            byte[] bytes = loadClassData(path);
            return defineClass(name, bytes, 0, bytes.length);
        }
        return null;
    }

    private byte[] loadClassData(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            int i;
            while ((i = fis.read()) != -1) {
                outputStream.write(255 - i);
            }
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
