package com.uitest.pages;

import com.uitest.manage.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

    BasePage() {
        driver = DriverFactory.getDriver();
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name = 'sub']")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@class = 'heading3']")
    public WebElement messageLine;

    static final String NEW_ACCOUNT_URL = "http://demo.guru99.com/v4/manager/addAccount.php";
    static final String NEW_CUSTOMER_URL = "http://demo.guru99.com/v4/manager/addcustomerpage.php";
    static final String DEPOSIT_URL = "http://demo.guru99.com/v4/manager/DepositInput.php";
}
