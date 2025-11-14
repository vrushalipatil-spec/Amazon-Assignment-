package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.assignment.utils.WaitUtils;

public class OrdersPage {
    private WebDriver driver;
    private By ordersLink = By.id("nav-orders");

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToOrders() {
        driver.findElement(ordersLink).click();
        WaitUtils.getWait(driver, 10).until(d -> d.findElement(By.tagName("body")) != null);
    }

    public void selectPastYear() {
        // placeholder; actual selector may vary
        try {
            driver.findElement(By.xpath("//a[contains(., 'Past 1 year') or contains(., 'Past year')]")).click();
        } catch (Exception e) {
            // ignore if not present
        }
    }
}
