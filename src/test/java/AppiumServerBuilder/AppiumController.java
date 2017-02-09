package AppiumServerBuilder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dwanniarachchi on 08/2/17.
 */
public class AppiumController {

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS
    }
    public static AppiumController instance = new AppiumController();
    public AppiumDriver driver;

    public void startAppiumServer() {

        CommandLine command = new CommandLine("/usr/local/bin/node");
        command.addArgument("/usr/local/bin/appium", false);
        command.addArgument("--address", false);
        command.addArgument("0.0.0.0");
        command.addArgument("--port", false);
        command.addArgument("4723");
        command.addArgument("--full-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(command, resultHandler);
            Thread.sleep(5000);
            //Utility.Log.info("Appium server started successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            //Utility.Log.error(e.getStackTrace().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            //Utility.Log.error(e.getStackTrace().toString());
        }
    }

    public void stopAppiumServer() {
        String[] command = { "/usr/bin/killall", "-KILL", "node" };
        try {
            Runtime.getRuntime().exec(command);
            //Utility.Log.info("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
            //Utility.Log.error(e.getStackTrace().toString());
        }
    }

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File (appDir, "Contacts.apk");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("avd", "Android7");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Android7");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("fullReset", false);
                capabilities.setCapability("appPackage", "com.jayway.contacts");
                capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app/iOS/");
                app = new File(appDir, "ContactsSimulator.app");
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 7");
                capabilities.setCapability("platformVersion","10.2");
                capabilities.setCapability("AutomationName", "XCUITest");
                capabilities.setCapability("app", app.getAbsolutePath());
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
