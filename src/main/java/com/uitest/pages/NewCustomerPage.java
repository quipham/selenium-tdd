package com.uitest.pages;

import com.uitest.model.Customer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class NewCustomerPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'name']")
    WebElement customnerNameInput;

    @FindBy(xpath = "//*[@value = 'm']")
    WebElement maleRadio;

    @FindBy(xpath = "//*[@value = 'f']")
    WebElement femaleRadio;

    @FindBy(id = "dob")
    WebElement datePicker;

    @FindBy(xpath = "//textarea[@name = 'addr']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@name = 'city']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@name = 'state']")
    WebElement stateInput;

    @FindBy(xpath = "//input[@name = 'pinno']")
    WebElement pinInput;

    @FindBy(xpath = "//input[@name = 'telephoneno']")
    WebElement phoneInput;

    @FindBy(xpath = "//input[@name = 'emailid']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passInput;

    @FindBy(xpath = "(//tr/td)[6]")
    public WebElement customerId;

    public void open() {
        driver.get(NEW_CUSTOMER_URL);
        assertEquals(driver.getCurrentUrl(), NEW_CUSTOMER_URL);
    }

    public void addNew(Customer customer) {
        customnerNameInput.sendKeys(customer.getName());
        if (customer.getGender().equals("male"))
            maleRadio.click();
        if (customer.getGender().equals("female"))
            femaleRadio.click();
        datePicker.sendKeys(customer.getDob());
        addressInput.sendKeys(customer.getAddress());
        cityInput.sendKeys(customer.getCity());
        stateInput.sendKeys(customer.getState());
        pinInput.sendKeys(customer.getPin());
        phoneInput.sendKeys(customer.getMobileNumber());
        emailInput.sendKeys(customer.getEmail());
        passInput.sendKeys(customer.getPass());
        submitBtn.click();
    }
}
