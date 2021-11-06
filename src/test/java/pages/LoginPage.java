package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By logo = By.className("login_logo");
    By username = By.cssSelector("[data-test='username']");
    By password = By.cssSelector("[data-test='password']");
    By loginButton = By.cssSelector("[data-test='login-button']");
    By errorMessage = By.cssSelector("[data-test='error']");
    By usernameCrossIcon = By.cssSelector("[data-test='username']+[data-icon='times-circle']");
    By passwordCrossIcon = By.cssSelector("[data-test='password']+[data-icon='times-circle']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void checkLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        boolean logoDisplayed = driver.findElement(loginButton).isDisplayed();
        Assert.assertTrue(logoDisplayed, "Logo is not displayed");

    }

    public void checkUsernameField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        boolean usernameDisplayed = driver.findElement(username).isDisplayed();
        Assert.assertTrue(usernameDisplayed, "Username field is not displayed");

    }

    public void checkPasswordField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        boolean passwordDisplayed = driver.findElement(password).isDisplayed();
        Assert.assertTrue(passwordDisplayed, "Password field is not displayed");
    }

    public void checkLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        boolean loginButtonDisplayed = driver.findElement(loginButton).isDisplayed();
        Assert.assertTrue(loginButtonDisplayed, "Password field is not displayed");

    }
}

