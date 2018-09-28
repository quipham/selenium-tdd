package de.anibis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    @FindBy(id = "ctl00_phlContent_txtUsername")
    public WebElement userText;

    @FindBy(id = "ctl00_phlContent_txtPassword")
    public WebElement passText;

    @FindBy(id = "ctl00_phlContent_btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "ctl00_phlContent_txtUsername-error")
    public WebElement userTextErrorMsg;

    @FindBy(id = "ctl00_phlContent_txtPassword-error")
    public WebElement passTextErrorMsg;


    public void open() {
        driver.get(LOGIN_URL);
        assertTrue(loginBtn.isDisplayed());
    }

    public void login(String user, String pass) {
        userText.sendKeys(user);
        passText.sendKeys(pass);
        loginBtn.click();
    }

    public boolean isCursorOnUserTextBox() {
        String selectionStart = js.executeScript("return document.getElementById(\"ctl00_phlContent_txtUsername\").selectionStart").toString();
        String rightPosition = js.executeScript("return document.getElementById(\"ctl00_phlContent_txtUsername\").getBoundingClientRect().right").toString();
        return selectionStart.equals(rightPosition);
    }

    public boolean isTextBoxShowError(WebElement textBox) {
        String backGroundCSS = "rgb(255, 236, 236) none repeat scroll 0% 0% / auto padding-box border-box";
        return textBox.getCssValue("background").equals(backGroundCSS);
    }
}
