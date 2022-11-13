package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputUsername;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy (id = "submit-form")
    public WebElement submitBtn;



    public void login (String username, String password){

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);

    }


}
