package com.assignment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.assignment.pages.LoginPage;
import com.assignment.pages.HomePage;
import com.assignment.pages.ProductPage;
import com.assignment.pages.OrdersPage;

public class LoginRequiredTests extends BaseTest {

    @Test
    public void primeFilterAndDeliveryDate() {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        login.login(config.get("username"), config.get("password"));
        home.search("mobile");
        product.applyPrimeFilter();
        String delivery = product.getFirstItemDelivery();
        System.out.println("Delivery: " + delivery);
        Assert.assertNotNull(delivery);
    }

    @Test
    public void ordersPaymentAddressPlaceholders() {
        LoginPage login = new LoginPage(driver);
        OrdersPage orders = new OrdersPage(driver);

        login.login(config.get("username"), config.get("password"));
        orders.goToOrders();
        orders.selectPastYear();
        // placeholders for add payment/address
        Assert.assertTrue(true);
    }
}
