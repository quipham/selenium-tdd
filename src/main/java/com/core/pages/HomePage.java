package com.core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//b[text() = 'Đăng nhập']/../..")
    WebElement loginBtn;

    public void navigateToLoginPage() {
        clickElement(loginBtn);
    }
}
