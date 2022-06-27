package com.core;

import static com.core.utils.CommonUtils.*;

import com.core.manage.DriverFactory;
import com.core.model.YamlConfig;
import com.core.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected YamlConfig config;
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUpClass() {
        setYamlConfig();
        config = getYamlConfig();
        String baseUrl = config.getWebUrl();
        DriverFactory.setDriver(DriverFactory.initializeDriver(config.getFlags().getBrowser()));
        driver = DriverFactory.getDriver();
        homePage = new HomePage();
        loginPage = new LoginPage();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDownClass() {
        DriverFactory.closeDriver();
    }
}
