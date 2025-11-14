package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.assignment.utils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private By dealsSelector = By.cssSelector("div.DealCard, div.DealGridItem-module__dealItem, a[data-testid]"); 
    private By addToCart = By.id("add-to-cart-button");
    private By cartCount = By.id("nav-cart-count");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectThirdDeal() {
        WaitUtils.getWait(driver, 15).until(d -> d.findElements(dealsSelector).size() > 2);
        List<WebElement> deals = driver.findElements(dealsSelector);
        deals.get(2).click();
    }

    public void addMinQuantity(int qty) {
        WaitUtils.getWait(driver, 10).until(d -> d.findElement(addToCart).isDisplayed());
        try {
            driver.findElement(addToCart).click();
            WaitUtils.getWait(driver, 10).until(d -> Integer.parseInt(d.findElement(cartCount).getText().trim()) >= qty);
        } catch (Exception e) {
            // ignore for some products
        }
    }

    public int getCartQuantity() {
        try {
            String t = driver.findElement(cartCount).getText().trim();
            return Integer.parseInt(t);
        } catch (Exception e) {
            return 0;
        }
    }

    public String getLastDisplayedItemAfterScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i=0;i<5;i++) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try { Thread.sleep(800); } catch (InterruptedException e) {}
        }
        List<WebElement> titles = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal, h2 a span"));
        if (!titles.isEmpty()) return titles.get(titles.size()-1).getText();
        return "<none>";
    }

    public void applyPrimeFilter() {
        try {
            WebElement prime = driver.findElement(By.xpath("//li//span[text()='Prime'] | //label[contains(., 'Prime')]/input"));
            if (!prime.isSelected()) prime.click();
        } catch (Exception e) {
            // ignore
        }
    }

    public String getFirstItemDelivery() {
        try {
            List<WebElement> items = driver.findElements(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"));
            if (items.isEmpty()) return "<no-items>";
            WebElement first = items.get(0);
            try {
                return first.findElement(By.xpath(".//span[contains(text(),'Delivery') or contains(text(),'Arrives') or contains(text(),'Get it')]")).getText();
            } catch (Exception ex) {
                return "<delivery-not-found>";
            }
        } catch (Exception e) {
            return "<error>";
        }
    }
}
