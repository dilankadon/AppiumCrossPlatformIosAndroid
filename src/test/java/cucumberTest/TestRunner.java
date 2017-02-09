package cucumberTest;

/**
 * Created by dwanniarachchi on 30/1/17.
 */

import AppiumServerBuilder.AppiumController;
import Utility.Log;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature"
        ,glue = {"stepDefinition"}
        ,tags = {"@Test"}
        ,format = {"pretty","json:target/cucumber.json"}
)

public class TestRunner{

    @BeforeClass
    public static void launchAppiumServer() throws MalformedURLException {

        DOMConfigurator.configure("log4j.xml");
        AppiumController.instance.startAppiumServer();
        Log.startTestCase();
    }

    @AfterClass
    public static void killAppiumServer() throws IOException {
        Log.endTestCase("E-N-D");
        AppiumController.instance.stopAppiumServer();
    }
}
