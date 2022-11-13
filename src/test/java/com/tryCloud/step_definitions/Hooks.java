package com.tryCloud.step_definitions;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){
        //we will implement taking screenshot in this method
        //System.out.println("Closing browser using cucumber @After each scenario");

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        BrowserUtils.waitFor(5);

        Driver.closeDriver();
    }

    //@Before(value = "@login")
//    public void setupScenario(){
//
//    }
    //@Before
//    public void setupScenario(){
//    }

    //@Before(value = "@login")
    public void setupForLogin(){
        //If you want any code to run before any specific feature
        //you can use value = "@tagname" to determine this
    }

    //@Before(value = "@db", order=3)
    public void setupDatabaseScenario(){
    }

    //@BeforeStep
    public void setupScenarioStep(){
        System.out.println("Setting up browser using cucumber @Before each scenario step");
    }

    //@BeforeStep
    public void setupScenarioStepLogin(){
        System.out.println("Setting up browser using cucumber @Before each scenario step for login");
    }
}
