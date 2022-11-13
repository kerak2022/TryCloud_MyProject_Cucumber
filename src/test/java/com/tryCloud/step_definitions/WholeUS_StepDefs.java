package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.pages.US3Page;
import com.tryCloud.pages.US4PAge;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class WholeUS_StepDefs {

    LoginPage loginPage = new LoginPage();

    BasePage basePage = new LoginPage();
    US3Page us3Page = new US3Page();

    US4PAge us4PAge = new US4PAge();

    @Given("user on the login page")
    public void userOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String username, String password) {
        BrowserUtils.waitFor(2);
        basePage.login(username, password);
    }


    @When("user click the login button")
    public void user_click_the_login_button() {
         BrowserUtils.waitFor(2);
       basePage.submitBtn.click();
    }


    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));



    }


    @When("user enter invalid {string} and {string}")
    public void userEnterInvalidAnd(String username, String password) {
        basePage.login(username, password);

    }

    @Then("verify {string} message should be displayed")
    public void verifyMessageShouldBeDisplayed(String message) {

         Assert.assertEquals(message, loginPage.warningMessage.getText());

    }

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {

        basePage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        basePage.submitBtn.click();
        BrowserUtils.waitFor(2);
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModulesText) {


        List<String> actualModules = us3Page.allModulesText();

        Assert.assertEquals(expectedModulesText, actualModules);

      // Assert.assertEquals(expectedModulesText, BrowserUtils.getElementsText(us3Page.modules));

    }

    //User story 4 : As a user, I should be able to access to Files module.

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        basePage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        basePage.submitBtn.click();
        BrowserUtils.waitFor(2);
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String expectedModule) {


      us4PAge.clickTheModule(expectedModule);


    }
    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());

    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        BrowserUtils.waitFor(4);
          us4PAge.checkAllButtons.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {

        us4PAge.assertCheckBtnSelected();

    }


}
