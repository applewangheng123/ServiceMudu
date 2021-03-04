package com.wh.testapi.wework;

import java.util.Properties;

public class SystemVar {

    private static Properties cache = new Properties();

    static {
        try {
            cache.load(ClassLoader.class.getResourceAsStream("/wh.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return cache.getProperty(key);
    }
    public static void main(String[] args) {
        System.out.println(getValue("Host.url"));
        System.out.println(getValue("Environment"));
        System.out.println(getValue("server.port"));
    }

}
