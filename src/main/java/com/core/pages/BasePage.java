package com.core.pages;

import static java.time.Duration.ofSeconds;

import com.core.manage.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, ofSeconds(15));
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElementByJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void clickElement(WebElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    protected void sendKeys(WebElement e, String value) {
        wait.until(ExpectedConditions.visibilityOf(e));
        e.sendKeys(value);
    }
}
