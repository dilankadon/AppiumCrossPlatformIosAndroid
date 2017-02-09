package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dwanniarachchi on 8/2/17.
 */
public class ContactSearchPageAndroid_IOS implements ContactSearchPage {

    public ContactSearchPageAndroid_IOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "name")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[1]")
    public MobileElement firstSearchResultName;

    @AndroidFindBy(id = "main_search")
    @iOSFindBy(xpath = "//XCUIElementTypeSearchField[1]")
    public MobileElement searchField;

    public void search(String name) {
        searchField.sendKeys(name);
    }

    public MobileElement getFirstSearchResult() { return firstSearchResultName; }
    public MobileElement getSearchField() {
        return searchField;
    }

}
