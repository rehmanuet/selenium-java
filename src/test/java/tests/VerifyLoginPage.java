package tests;

import com.relevantcodes.extentreports.LogStatus;
import extent.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.lang.reflect.InvocationTargetException;

import static utils.Constants.*;
import static utils.FileUtils.getMessage;

public class VerifyLoginPage extends BaseTest {

    @Test
    public void tc001_verifyLoginPageElements() {
        ExtentTestManager.startTest("TC001-VerifyLoginPageElement", "Verification of Login Page elements");
        try {
            page.getInstance(LoginPage.class).checkLogo();
            page.getInstance(LoginPage.class).checkUsernameField();
            page.getInstance(LoginPage.class).checkPasswordField();
            page.getInstance(LoginPage.class).checkLoginButton();
            ExtentTestManager.getTest().log(LogStatus.PASS, "All elements are displayed");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }

    @Test
    public void tc002_verifyValidLogin() {
        ExtentTestManager.startTest("TC002-VerifyValidLogin", "Verification of Login with valid credentials");
        try {
            page.getInstance(LoginPage.class).doLogin(VALID_USERNAME, VALID_PASSWORD);
            page.getInstance(LoginPage.class).checkLoginSuccessfully();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Logged-in Successfully");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }

    @Test
    public void tc003_verifyInvalidLogin() {
        ExtentTestManager.startTest("TC002-VerifyInvalidLogin", "Verification of Login with invalid credentials");
        try {
            page.getInstance(LoginPage.class).doLogin(INVALID_USERNAME, INVALID_PASSWORD);
            page.getInstance(LoginPage.class).checkLoginError(getMessage(LOGIN_ERROR_MESSAGE));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Error Message Displayed Successfully");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }
}