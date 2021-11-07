package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Implementation of the page layer for the Login Page
 */

public class LoginPage extends BasePage {

    By logo = By.className("login_logo");
    By username = By.cssSelector("[data-test='username']");
    By password = By.cssSelector("[data-test='password']");
    By loginButton = By.cssSelector("[data-test='login-button']");
    By errorMessage = By.cssSelector("[data-test='error']");
    By usernameCrossIcon = By.cssSelector("[data-test='username']+[data-icon='times-circle']");
    By passwordCrossIcon = By.cssSelector("[data-test='password']+[data-icon='times-circle']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkLogo() {
        Assert.assertTrue(isVisible(logo), "Logo is not displayed");
    }

    public void checkUsernameField() {
        Assert.assertTrue(isVisible(username), "Username field is not displayed");
    }

    public void checkPasswordField() {
        Assert.assertTrue(isVisible(password), "Password field is not displayed");
    }

    public void checkLoginButton() {
        Assert.assertTrue(isVisible(loginButton), "Login button is not displayed");
    }

    public void doLogin(String uname, String pass) {
        isVisible(username);
        click(username);
        doSendKeys(username, uname);

        isVisible(password);
        click(password);
        doSendKeys(password, pass);

        isVisible(loginButton);
        click(loginButton);
    }

    public void checkLoginSuccessfully() {
        Assert.assertFalse(isVisible(loginButton), "Not Successfully Logged-in");
    }

    public void checkLoginError(String message) {
        Assert.assertTrue(isVisible(usernameCrossIcon), "Username Cross Icon is not displayed");
        Assert.assertTrue(isVisible(passwordCrossIcon), "Password Cross Icon is not displayed");
        Assert.assertEquals(doGetText(errorMessage), message);
    }
}

