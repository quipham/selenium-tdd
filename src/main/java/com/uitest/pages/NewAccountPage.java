package com.uitest.pages;

import com.uitest.model.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'cusid']")
    WebElement customerIdInput;

    @FindBy(xpath = "//select[@name = 'selaccount']")
    WebElement accountTypeSelect;

    @FindBy(xpath = "//input[@name = 'inideposit']")
    WebElement initialDepositInput;

    @FindBy(xpath = "(//tr/td)[6]")
    public WebElement accountId;

    @FindBy(xpath = "(//tr/td)[18]")
    public WebElement currentBalance;

    @FindBy(xpath = "//*[@name = 'button2']")
    WebElement submitNewAccountBtn;

    public void addNew(Account account) {
        String savings = "Savings";
        String current = "Current";
        customerIdInput.sendKeys(account.getCustomerId());
        Select selectAccountType = new Select(accountTypeSelect);
        if (account.getAccountType().equals(savings))
            selectAccountType.selectByValue(savings);
        if (account.getAccountType().equals(current))
            selectAccountType.selectByValue(current);
        initialDepositInput.sendKeys(account.getInitialDeposit());
        submitNewAccountBtn.click();
    }
}
