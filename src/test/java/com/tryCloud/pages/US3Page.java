package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class US3Page {

    public US3Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> modules;

    public List<String> allModulesText() {

        List<String> modulesText = new ArrayList<>();

        for (int i = 0; i < modules.size()-1; i++) {
            BrowserUtils.hover(modules.get(i));
            BrowserUtils.sleep(1);
            modulesText.add(modules.get(i).getText());
        }

          return modulesText;

    }

    public void clickTheModule(String name){


    }

}


