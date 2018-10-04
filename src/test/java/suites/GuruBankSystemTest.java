package suites;

import com.uitest.BaseTest;
import com.uitest.model.Account;
import com.uitest.model.Customer;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GuruBankSystemTest extends BaseTest {
    private String userId = "mngr153896";
    private String pass = "rUdebuz";
    private String generatedString = RandomStringUtils.randomAlphabetic(10).toLowerCase();
    private Customer customer = new Customer()
            .setName("Qui Pham")
            .setGender("male")
            .setDob("14/08/1990")
            .setAddress("377 Ly Thai To")
            .setCity("HCM")
            .setState("ThuDuc")
            .setPin("369121")
            .setMobileNumber("0909778899")
            .setEmail(generatedString + "@gmail.com")
            .setPass("123456");
    private Account account = new Account()
            .setAccountType("Current")
            .setInitialDeposit("10000");

    @Test(priority = 1)
    public void verifyNewCustomerCanBeCreated() {
        loginPage.login(userId, pass);
        leftMenuPage.openNewCustomerPage();
        newCustomerPage.addNew(customer);
        assertEquals(newCustomerPage.messageLine.getText(), "Customer Registered Successfully!!!");
        customer.setCustomerId(newCustomerPage.customerId.getText());
    }

    @Test(priority = 2)
    public void verifyCreateNewAccount() {
        account.setCustomerId(customer.getCustomerId());
        leftMenuPage.openNewAccountPage();
        newAccountPage.addNew(account);
        account.setAccountId(newAccountPage.accountId.getText());
        account.setBalance(newAccountPage.currentBalance.getText());
        assertEquals(newAccountPage.messageLine.getText(), "Account Generated Successfully!!!");
        assertEquals(account.getInitialDeposit(), account.getBalance());
    }

    @Test(priority = 3)
    public void verifyDepositSuccessful() {
        String amount = "500";
        String description = "desc";
        leftMenuPage.openDepositPage();
        depositPage.deposit(account.getAccountId(), amount, description);
        assertEquals(depositPage.messageLine.getText(), "Transaction details of Deposit for Account " + account.getAccountId());
        assertEquals(depositPage.amountCredited.getText(), amount);
        assertEquals(depositPage.description.getText(), description);
        int currentBalance = Integer.valueOf(account.getBalance());
        int amountInput = Integer.valueOf(amount);
        int balanceAfterDeposit = Integer.valueOf(depositPage.currentBalance.getText());
        assertEquals(balanceAfterDeposit, currentBalance + amountInput);
    }
}
