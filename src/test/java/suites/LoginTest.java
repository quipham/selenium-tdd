package suites;

import com.core.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyNewCustomerCanBeCreated() {
        String phone = config.getData().getCustomer().getMobileNumber();
        String pass = config.getData().getCustomer().getPass();
        homePage.navigateToLoginPage();
        loginPage.login(phone, pass);
        assertEquals(homePage.messageLine.getText(), "Customer Registered Successfully!!!");
    }
}
