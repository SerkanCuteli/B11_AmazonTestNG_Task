package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement l_helloUser;
    @FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
    public WebElement l_signInBtn;
    @FindBy(xpath = "//span[text()='Neue Liste anlegen ']")
    public WebElement l_create_a_List;
    @FindBy(id = "searchDropdownBox")
    public WebElement l_searchDropdownBox;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement l_searchtextbox;
    @FindBy(id = "nav-search-submit-button")
    public WebElement l_search_submitBtn;


    public void getLogInPupUp() {
        BrowserUtils.hover(l_helloUser);
        l_signInBtn.click();
    }

    public void verifyLogin() {
        Assert.assertTrue(l_helloUser.getText().contains(ConfigurationReader.get("username")));
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String menu) {
        Select dropDown = new Select(element);
        BrowserUtils.waitFor(2);
        dropDown.selectByVisibleText(menu);
    }

    public void selectCategoryForSearch(String category) {
        BrowserUtils.waitFor(2);
        selectByVisibleTextFromDropDown(l_searchDropdownBox, category);
    }

    public void verifySelectedCategory(String category) {
        Select dropDown = new Select(l_searchDropdownBox);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), category);
    }
    public void searchProduct(String product){
        BrowserUtils.waitFor(1);
        l_searchtextbox.sendKeys(product);
        BrowserUtils.waitFor(1);
        l_search_submitBtn.click();


    }



}
