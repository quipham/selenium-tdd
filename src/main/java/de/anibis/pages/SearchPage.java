package de.anibis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(id = "ctl00_phlContent_Filter_ddlState")
    WebElement selectState;

    @FindBy(id = "ctl00_phlContent_Filter_ctlLocation_ddlDistance")
    WebElement selectDistance;

    @FindBy(xpath = "(//span[contains(text(),'Appliquer')])[3]")
    WebElement filterApplyBtn;

    @FindBy(xpath = "//li[@class = 'horizontal-list-item item-date']")
    public List<WebElement> searchResultsList;

    public void selectStateOption(String state) {
        Select stateOption = new Select(selectState);
        stateOption.selectByValue(state);
    }

    public void selectDistanceOption(String distance) {
        Select distanceOption = new Select(selectDistance);
        distanceOption.selectByValue(distance);
    }

    public void applyFilter() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(filterApplyBtn));
        filterApplyBtn.click();
    }

    public List<String> getListItemDates() {
        List<String> list = new ArrayList<>();
        for (WebElement element: searchResultsList)
            list.add(element.getText());
        return list;
    }

}
