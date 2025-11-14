package com.assignment.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties props = new Properties();

    public ConfigReader() {
        try (FileInputStream in = new FileInputStream("src/test/resources/config.properties")) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
