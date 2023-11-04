package com.amazon.tests;

import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.YourListPage;
import com.amazon.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase{
    /**
     * Amazon E2E Task
     * go to amazon web page : https://www.amazon.com/
     * if there are cookies accept cookies
     * log in with your own valid credential
     * Verify that login is successful
     * Create a new list from Account and Lists
     * Select any category from the section tab next to the search box
     * Verify that category is selected
     * Write any product to search box and click
     * Verify that the result contains product items
     */

    LoginPage loginPage;
    YourListPage yourListPage;
    ProductPage productPage;
    Faker faker;
    String listName;
    String expectedListName;
    String category;
    String product;

    @Test
    public void t_e2e_LoginAndCreateListAndCategorySearch() {
        loginPage = new LoginPage();
        yourListPage = new YourListPage();
        productPage = new ProductPage();
        faker = new Faker();
        listName =faker.harryPotter().house();
        expectedListName = listName;
        category = "Computers";
        product = "Hp";
        extentLogger = report.createTest("Amazon E2E Test");
        extentLogger.info("go to " + ConfigurationReader.get("url")+ " web page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("log in with " +ConfigurationReader.get("username") + " credential");
        loginPage.login();
        extentLogger.info("Verify that login is successful");
        loginPage.verifyLogin();
        extentLogger.info("Create a new list from Account and Lists");
        yourListPage.createNewList(listName);
        System.out.println("listName = " + listName);
        System.out.println("expectedListName = " + expectedListName);
        extentLogger.info("Verify that "+listName+" is created in your list page");
        yourListPage.verifyList(expectedListName);
        extentLogger.info("Select any " + category + " from the section tab next to the search box");
        productPage.selectCategoryForSearch(category);
        extentLogger.info("Verify that " + category + " is selected");
        productPage.verifySelectedCategory(category);
        extentLogger.info("Write any " + product + " to search box and click");
        productPage.searchProduct(product);
        extentLogger.info("Verify that the result contains " + product + " items");
        productPage.verifySearchResult(product);

    }
}
