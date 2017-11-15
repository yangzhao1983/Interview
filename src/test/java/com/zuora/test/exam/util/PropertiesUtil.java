package com.zuora.test.exam.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertiesUtil {

    /*
     * This Util class can read value by key
     * from /properties/test.properties
     */
    private static ResourceBundle testProperties = null;

    public static String getValue(String key) {
        return testProperties.getString(key);
    }

    public static ResourceBundle getTestProperties() {
        if (testProperties != null)
            return testProperties;
        testProperties = getProperties("/properties/test.properties");
        return testProperties;
    }

    public static ResourceBundle getProperties(String location) {
        PropertyResourceBundle bundle = null;
        try {
            String path = System.getProperty("user.dir");
            InputStream in = new BufferedInputStream(new FileInputStream(path + location));
            bundle = new PropertyResourceBundle(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bundle;
    }
}
