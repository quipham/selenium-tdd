package com.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='tel']")
    WebElement telInput;

    @FindBy(css = "input[type='password']")
    WebElement passInput;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public void login(String userId, String pass) {
        sendKeys(telInput, userId);
        sendKeys(passInput, pass);
        clickElement(submitBtn);
    }
}
