package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'Vorschlägen')]/..")
    public WebElement l_resultsForSearchProduct;

    public void verifySearchResult(String product){
        BrowserUtils.waitForVisibility(l_resultsForSearchProduct, 10);
        Assert.assertTrue(l_resultsForSearchProduct.getText().contains(product));
    }
}

