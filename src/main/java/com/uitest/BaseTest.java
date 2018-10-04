package com.uitest;

import com.uitest.manage.DriverFactory;
import com.uitest.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected NewCustomerPage newCustomerPage;
    protected LeftMenuPage leftMenuPage;
    protected NewAccountPage newAccountPage;
    protected DepositPage depositPage;

    @BeforeClass
    public void setUp() {
        String baseUrl = "http://demo.guru99.com/v4/index.php";
        DriverFactory.setDriver(DriverFactory.initializeDriver("chrome"));
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
        leftMenuPage = new LeftMenuPage();
        newCustomerPage = new NewCustomerPage();
        newAccountPage = new NewAccountPage();
        depositPage = new DepositPage();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
