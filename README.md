# Appium Cross Platform Cucumber Example for Ios & Android
Example project for Appium cross platform testing of an iOS and an Android application using Cucumber

###Pre-requisites:
    
    Download and setup Appium (see http://appium.io/getting-started.html)

###Instructions:

    1. Clone this project and import as a maven project in IntelliJ or Eclipse.
    
    2. Set the executionOS variable in the AppiumController class (src/test/java/AppiumServerBuilder/AppiumController.java) to Android or iOS depending on what platform you want to execute the example test on. 
    
    3. Run mvn clean install to run tests and generate Cucumber-html report

        Report Location : /target/site/cucumber-reports

    4. Log file : /logfile.log
