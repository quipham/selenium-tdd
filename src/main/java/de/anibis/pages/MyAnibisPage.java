package de.anibis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAnibisPage extends BasePage {
    @FindBy(xpath = "//strong")
    List<WebElement> informationList;

    public String getUserName() {
        return informationList.get(0).getText();
    }
}
