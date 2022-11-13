package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US4PAge {

    public US4PAge() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

 @FindBy (xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> allNames;

    public void clickTheModule(String module){

        for (int i = 0; i < allNames.size(); i++) {
            BrowserUtils.hover(allNames.get(i));
            if(allNames.get(i).getText().equals(module)){
                allNames.get(i).click();
                break;
            }

        }
    }


   @FindBy (xpath = "//label[@for='select_all_files']")
    public WebElement checkAllButtons;


    @FindBy (xpath = "//input[@class='selectCheckBox checkbox']")
    public List<WebElement> allCheckBoxes;

    public void assertCheckBtnSelected (){

        for (WebElement allCheckBox : allCheckBoxes) {
            Assert.assertTrue(allCheckBox.isSelected());

        }


    }






}
