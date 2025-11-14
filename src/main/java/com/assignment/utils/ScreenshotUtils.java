package com.assignment.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {
    public static void capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("target/screenshots/" + name + ".png");
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
