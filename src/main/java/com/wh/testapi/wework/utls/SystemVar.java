package com.wh.testapi.wework.utls;

import java.util.Properties;

//读取多环境的配置文件

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
