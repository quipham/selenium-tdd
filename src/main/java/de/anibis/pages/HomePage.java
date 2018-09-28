package de.anibis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class HomePage extends BasePage {
    @FindBy(id = "ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@id = 'ctl00_Header1_ctlHeaderActionBar_ctlMemberNavigation_divMyProfile']/a")
    WebElement myAnibisBtn;

    @FindBy(xpath = "//a[contains(text(),'Immobilier')]")
    WebElement immobilienBtn;

    public void open() {
        driver.get(BASE_URL);
    }

    public void navigateToLoginPage() {
        loginBtn.click();
        assertEquals(driver.getCurrentUrl(), LOGIN_URL);
    }

    public void navigateToAnibisProfilePage() {
        loginBtn.click();
        myAnibisBtn.click();
        assertEquals(driver.getCurrentUrl(), MEMBER_PROFILE_URL);
    }

    public void navigateToImmobilienSearch() {
        immobilienBtn.click();
    }
}
