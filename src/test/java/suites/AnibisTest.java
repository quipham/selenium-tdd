package suites;

import de.anibis.BaseTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AnibisTest extends BaseTest {
    //Login Test
    @Test
    public void verifyCursorIsOnUserTextBoxAtTheFirstTime() {
        homePage.open();
        homePage.navigateToLoginPage();
        assertTrue(loginPage.isCursorOnUserTextBox());
    }

    @Test
    public void verifyTextBoxShowErrorMessage() {
        String invalidInputError = "Nous avons besoin de cette information";
        loginPage.open();
        loginPage.login("", "");
        assertTrue(loginPage.isTextBoxShowError(loginPage.userText));
        assertTrue(loginPage.isTextBoxShowError(loginPage.passText));
        assertEquals(loginPage.userTextErrorMsg.getText(), invalidInputError);
        assertEquals(loginPage.passTextErrorMsg.getText(), invalidInputError);
    }

    @Test
    public void verifyLoginSuccessfulWithValidProfile() {
        String user = "ani_test_2";
        String pass = "ani_test_2";
        loginPage.open();
        loginPage.login(user, pass);
        homePage.navigateToAnibisProfilePage();
        assertEquals(myAnibisPage.getUserName(), user);
    }

    //Search Test
    @Test
    public void verifySearchFunction() {
        String state = "zh";
        String distance = "10";
        homePage.open();
        homePage.navigateToImmobilienSearch();
        searchPage.selectStateOption(state);
        searchPage.selectDistanceOption(distance);
        searchPage.applyFilter();
        assertEquals(searchPage.searchResultsList.size(), 20);
    }

    @Test
    public void verifySortFunction() {
        List<String> listItemDate = searchPage.getListItemDates();
        List<String> sortListByDate = listItemDate.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        assertEquals(listItemDate, sortListByDate);
    }

}
