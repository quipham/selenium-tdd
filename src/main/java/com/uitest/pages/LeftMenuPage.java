package com.uitest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class LeftMenuPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'New Customer')]")
    WebElement newCustomerBtn;

    @FindBy(xpath = "//*[contains(text(), 'New Account')]")
    WebElement newAccountBtn;

    @FindBy(xpath = "//*[contains(text(), 'Deposit')]")
    WebElement depositBtn;

    public void openNewCustomerPage() {
        newCustomerBtn.click();
        assertEquals(driver.getCurrentUrl(), NEW_CUSTOMER_URL);
    }

    public void openNewAccountPage() {
        newAccountBtn.click();
        assertEquals(driver.getCurrentUrl(), NEW_ACCOUNT_URL);
    }

    public void openDepositPage() {
        depositBtn.click();
        assertEquals(driver.getCurrentUrl(), DEPOSIT_URL);
    }
}
