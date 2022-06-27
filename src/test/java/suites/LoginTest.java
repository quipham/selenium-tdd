package suites;

import com.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginSuccessfulWithCorrectCredential() {
        String phone = config.getData().getCustomer().getPhone();
        String pass = config.getData().getCustomer().getPass();
        homePage.navigateToLoginPage();
        loginPage.login(phone, pass);
        //TODO should assert something after login successful
        assertEquals("", "User login Successfully!!!");
    }
}
