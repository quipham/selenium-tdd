package com.uitest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'accountno']")
    WebElement accountIdInput;

    @FindBy(xpath = "//input[@name = 'ammount']")
    WebElement amountInput;

    @FindBy(xpath = "//input[@name = 'desc']")
    WebElement descriptionInput;

    @FindBy(xpath = "(//tr/td)[8]")
    public WebElement amountCredited;

    @FindBy(xpath = "(//tr/td)[14]")
    public WebElement currentBalance;

    @FindBy(xpath = "(//tr/td)[12]")
    public WebElement description;

    @FindBy(xpath = "//*[@value = 'Submit']")
    WebElement submitDepositBtn;

    public void deposit(String accountId, String amount, String description) {
        accountIdInput.sendKeys(accountId);
        amountInput.sendKeys(amount);
        descriptionInput.sendKeys(description);
        submitDepositBtn.click();
    }

}
