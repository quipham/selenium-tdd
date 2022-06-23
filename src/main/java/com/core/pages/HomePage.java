package com.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@name = 'uid']")
    WebElement userInput;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passInput;

    @FindBy(xpath = "//input[@name = 'btnLogin']")
    WebElement loginBtn;

    public void login(String userId, String pass) {
        userInput.sendKeys(userId);
        passInput.sendKeys(pass);
        loginBtn.click();
    }
}
