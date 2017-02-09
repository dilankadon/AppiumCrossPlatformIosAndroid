package AppiumServerBuilder;

import io.appium.java_client.AppiumDriver;

/**
 * Created by dwanniarachchi on 8/2/17.
 */
public abstract class AppiumBaseClass {

    protected AppiumDriver driver() {
        return AppiumController.instance.driver;
    }

}
