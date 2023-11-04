package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "ap_email")
    public WebElement l_emailInput;
    @FindBy(id = "continue")
    public WebElement l_continueBtn;
    @FindBy(id = "ap_password")
    public WebElement l_passwordInput;
    @FindBy(id = "signInSubmit")
    public WebElement l_signInSubmitBtn;

    public void login(){
        getLogInPupUp();
        l_emailInput.sendKeys(ConfigurationReader.get("email"));
        l_continueBtn.click();
        l_passwordInput.sendKeys(ConfigurationReader.get("password"));
        l_signInSubmitBtn.click();

    }
}
