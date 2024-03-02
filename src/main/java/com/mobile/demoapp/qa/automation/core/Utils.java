package com.mobile.demoapp.qa.automation.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String getProperty(String property){
        Properties prop = new Properties();
        try {
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("config/env.properties");
            if (input != null) {
                prop.load(input);
            }
            return (prop.getProperty(property));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}