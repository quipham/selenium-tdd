package com.core.manage;

import static com.core.constant.Browser.*;

import com.core.constant.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver initializeDriver(String browserType) {
        WebDriver driver = null;
        if (browserType.equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
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
}
