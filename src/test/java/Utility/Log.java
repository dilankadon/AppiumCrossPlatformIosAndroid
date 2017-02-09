package Utility;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Don Dilanka on 23/05/2016.
 */
public class Log {

    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());
    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    public static void startTestCase(){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.info("****************************************************************************************");
        Log.info("*******************   "+ "AppiumCrossPlatformIosAndroid" + " : " + timeStamp + "    **********************");
        Utility.Log.info("****************************************************************************************");
    }

    //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.info("****************************************************************************************");
        Log.info("*****************************   "+ sTestCaseName + "  :  " + timeStamp + "    **********************");
        Log.info("****************************************************************************************");
    }

    public static void scenarioName(String scenarioName){
        Log.info("****************************************************************************************");
        Log.info("Scenario : " + scenarioName );
        Log.info("****************************************************************************************");
    }



    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }
    public static void warn(String message) {
        Log.warn(message);
    }
    public static void error(String message) {
        Log.error(message);
    }
    public static void fatal(String message) {
        Log.fatal(message);
    }
    public static void debug(String message) {
        Log.debug(message);
    }
}
