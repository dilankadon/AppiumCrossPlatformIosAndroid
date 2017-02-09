package stepDefinition;

import AppiumServerBuilder.AppiumBaseClass;
import AppiumServerBuilder.AppiumController;
import Utility.Log;
import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import PageObjects.*;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;

/**
 * Created by dwanniarachchi on 8/2/17.
 */

public class HomeScreenSteps extends AppiumBaseClass{

    protected ContactSearchPage searchPage;
    protected ContactDetailPage detailPage;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        AppiumController.instance.start();
        Log.scenarioName(scenario.getName());
        searchPage = new ContactSearchPageAndroid_IOS(driver());
        detailPage = new ContactDetailPageAndroid_IOS(driver());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = driver()
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
                //Utility.Log.error("Error occurred. ScreenShot Captured." + e.getMessage().toString());
            }
        }
            AppiumController.instance.stop();
    }

    @Given("^the app is running$")
    public void theAppIsRunning() throws MalformedURLException {
        AppiumController.instance.start();
        Log.info("The app is running");
    }

    @Given("^I am on the home screen$")
    public void iAmOnTheHomeScreen(){
        MobileElement SearchBox = searchPage.getSearchField();
        SearchBox.isDisplayed();
        Log.info("I am on the home screen");
    }

    @When("^I search for (.*)$")
    public void iSearchForTestUser(String searchString){
        searchPage.search(searchString);
        Log.info("I search for " + searchString);
    }

    @Then("^I am able to see (.*) on results list$")
    public void iAmAbleToSeeTestUserOnResultsList(String fullName){
        //Verify result
        MobileElement searchResult = searchPage.getFirstSearchResult();
        Assert.assertEquals(fullName, searchResult.getText());
        Log.info("I am able to see "+ fullName + " on results list");
    }

    @When("^I tap (.*) to view contact details$")
    public void iTapTestUserToViewProfile(String fullName){
        //Navigate to detail page
        //searchResult.click();
        searchPage.getFirstSearchResult().click();
        Log.info("I tap " + fullName + " to view contact details");

    }
    @Then("^I can view contact details of (.*)$")
    public void iCanViewContactDetails(String fullName){
        //Verify that correct page is displayed
        Assert.assertEquals(fullName, detailPage.getContactName());
        Log.info("I can view contact details of " + fullName);
    }
}
