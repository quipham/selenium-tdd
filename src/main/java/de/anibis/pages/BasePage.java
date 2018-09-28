package de.anibis.pages;

import de.anibis.manage.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

    BasePage() {
        driver = DriverFactory.getDriver();
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    static final String LOGIN_URL = "https://www.anibis.ch/fr/login.aspx";
    static final String BASE_URL = "https://www.anibis.ch/fr/default.aspx";
    static final String MEMBER_PROFILE_URL = "https://www.anibis.ch/member/profile.aspx?lng=de";
}
