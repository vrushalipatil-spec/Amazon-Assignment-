package com.assignment.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser) {
        if (browser == null || browser.isBlank() || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opts = new ChromeOptions();
            // Uncomment headless if needed for CI
            // opts.addArguments("--headless=new");
            opts.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(opts);
        }
        // fallback to chrome
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
