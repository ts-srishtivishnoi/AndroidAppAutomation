package com.mobile.demoapp.qa.automation.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import static com.mobile.demoapp.qa.automation.core.Utils.getProperty;



public class DriverManager {

     AppiumDriver driver;
     private static final String ANDROID_PROP = "src/main/resources/config/android-caps.json";


    public AppiumDriver getInstance() throws Exception {
        setAndroidDriver();
         return driver;
     }

    private void setAndroidDriver() {
        DesiredCapabilities androidCapabilities = new DesiredCapabilities();
        HashMap androidCaps = getDesiredCapabilities(ANDROID_PROP);
        File app = new File((String) androidCaps.get("app"));
        androidCapabilities.setCapability("deviceName", androidCaps.get("DeviceName"));
        androidCapabilities.setCapability("platformName", androidCaps.get("PlatformName"));
        androidCapabilities.setCapability("platformVersion", androidCaps.get("PlatformVersion"));
        androidCapabilities.setCapability("automationName", androidCaps.get("automationName"));
        androidCapabilities.setCapability("app", app.getAbsolutePath());
        setDriver("android",androidCapabilities);
    }

    private HashMap getDesiredCapabilities(String fileName) {

        ObjectMapper mapper = new ObjectMapper();
        HashMap map = new HashMap<>();
        try {
            File jsonFile = new File(fileName);
            map = mapper.readValue(jsonFile,HashMap.class);
            System.out.println("Getting instance of: " + map);

            return (map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }

    private void setDriver(String platform,DesiredCapabilities desiredCapabilities) {
        String APPIUM_SERVER_URL = getProperty("appium_server_url");
        try {
            
                    driver = new AndroidDriver(
                            new URL(APPIUM_SERVER_URL), desiredCapabilities);
                    System.out.println("Application Started....");
            }
            catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

