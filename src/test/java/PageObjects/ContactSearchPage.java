package PageObjects;

import io.appium.java_client.MobileElement;

/**
 * Created by dwanniarachchi on 8/2/17.
 */
public interface ContactSearchPage {

    void search(String name);
    MobileElement getSearchField();
    MobileElement getFirstSearchResult();

}
