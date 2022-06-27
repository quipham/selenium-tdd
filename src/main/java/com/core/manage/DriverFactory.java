package com.core.manage;

import static com.core.constant.Browser.*;
import static com.core.utils.CommonUtils.getResourceDir;
import static java.time.Duration.*;

import com.core.constant.Browser;
import com.core.utils.CommonUtils;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver initializeDriver(String browserType) {
        WebDriver driver = null;
        if (browserType.equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", getResourceDir() + "driver/chromedriver");
            driver = new ChromeDriver(chromeOptions());
            driver.manage().timeouts().implicitlyWait(ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(ofSeconds(60));
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static final ConcurrentHashMap<String, WebDriver> driverPool = new ConcurrentHashMap<>();

    public static synchronized void setDriver(WebDriver driver) {
        driverPool.put(Thread.currentThread().getName(), driver);
    }

    public static synchronized WebDriver getDriver() {
        return driverPool.get(Thread.currentThread().getName());
    }

    public static synchronized void closeDriver() {
        driverPool.get(Thread.currentThread().getName()).quit();
    }

    private DriverFactory() {
    }

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        return options;
    }
}
