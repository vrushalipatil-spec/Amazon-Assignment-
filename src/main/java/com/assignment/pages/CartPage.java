package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CartPage {
    private WebDriver driver;
    private By cartCount = By.id("nav-cart-count");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartQuantity() {
        try {
            String t = driver.findElement(cartCount).getText().trim();
            return Integer.parseInt(t);
        } catch (Exception e) {
            return 0;
        }
    }
}
