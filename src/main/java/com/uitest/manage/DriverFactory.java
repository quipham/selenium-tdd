package com.uitest.manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver initializeDriver(String browserType) {
        WebDriver driver = null;
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static ConcurrentHashMap<String, WebDriver> driverPool = new ConcurrentHashMap<>();

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
