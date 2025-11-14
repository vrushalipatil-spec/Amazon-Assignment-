package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.assignment.utils.WaitUtils;

public class HomePage {
    private WebDriver driver;
    private By todaysDeals = By.linkText("Today's Deals");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");
    private By leftNavButton = By.id("nav-hamburger-menu");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHome(String url) {
        driver.get(url);
    }

    public void openTodaysDeals() {
        WaitUtils.getWait(driver, 10).until(d -> d.findElement(todaysDeals).isDisplayed());
        driver.findElement(todaysDeals).click();
    }

    public void search(String q) {
        WaitUtils.getWait(driver, 10).until(d -> d.findElement(searchBox).isDisplayed());
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(q);
        driver.findElement(searchBtn).click();
    }

    public void openLeftNav() {
        WaitUtils.getWait(driver, 5).until(d -> d.findElement(leftNavButton).isDisplayed());
        driver.findElement(leftNavButton).click();
    }
}
