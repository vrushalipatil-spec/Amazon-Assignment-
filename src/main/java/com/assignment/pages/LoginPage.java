package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.assignment.utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;
    private By email = By.id("ap_email");
    private By cont = By.id("continue");
    private By password = By.id("ap_password");
    private By signIn = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        try {
            WaitUtils.getWait(driver, 10).until(d -> d.findElement(email).isDisplayed());
            driver.findElement(email).sendKeys(user);
            driver.findElement(cont).click();
            WaitUtils.getWait(driver, 10).until(d -> d.findElement(password).isDisplayed());
            driver.findElement(password).sendKeys(pass);
            driver.findElement(signIn).click();
        } catch (Exception e) {
            // login may need captcha/2FA - placeholder
        }
    }
}
