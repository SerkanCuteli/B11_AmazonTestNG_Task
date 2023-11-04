package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class YourListPage extends BasePage{

    @FindBy(id = "list-name")
    public WebElement l_listName;
    @FindBy(id = "wl-redesigned-create-list")
    public WebElement l_createListOnPupUp;
    @FindBy(css = "[role='heading'][aria-level='1']")
    public WebElement l_yourList_page;
    @FindBy(xpath = "//div[@class='wl-list-entry-title']")
    public List<WebElement> l_yourCreatedList;

    public void createNewList(String listName){
        BrowserUtils.hover(l_helloUser);
        BrowserUtils.waitForVisibility(l_create_a_List,10);
        l_create_a_List.click();
        BrowserUtils.waitForVisibility(l_listName, 10);
        l_listName.clear();
        l_listName.sendKeys(listName);
        l_createListOnPupUp.click();
        BrowserUtils.waitForVisibility(l_yourList_page, 10);
    }

    public void verifyList(String createdList){
        List<String> actualList = BrowserUtils.getElementsText(l_yourCreatedList);
        System.out.println("actualList.size() = " + actualList.size());
        System.out.println("actualList.toString() = " + actualList.toString());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(actualList.contains(createdList));

    }
}
