package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.LoginPage;

public class VerifyLoginPage {
    @Test
    public void verifyLogin() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.checkLogo();
        loginPage.checkUsernameField();
        loginPage.checkPasswordField();
        loginPage.checkLoginButton();
driver.close();
    }
}
