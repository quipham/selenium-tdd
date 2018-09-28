package de.anibis;

import de.anibis.manage.DriverFactory;
import de.anibis.pages.HomePage;
import de.anibis.pages.LoginPage;
import de.anibis.pages.MyAnibisPage;
import de.anibis.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Robot robot;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected MyAnibisPage myAnibisPage;
    protected SearchPage searchPage;

    @BeforeClass
    public void setUp() throws AWTException {
        DriverFactory.setDriver(DriverFactory.initializeDriver("chrome"));
        driver = DriverFactory.getDriver();
        robot = new Robot();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAnibisPage = new MyAnibisPage();
        searchPage = new SearchPage();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
