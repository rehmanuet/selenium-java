package tests;

import extent.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.Page;
import utils.Constants;
import utils.FileUtils;

import java.time.Duration;

import static utils.Constants.*;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;


    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.get(BASE_URL);
        page = new Page(driver, wait);
        FileUtils.getPropertyValue(Constants.MESSAGES_PROPERTIES_PATH,
                Constants.ON_FINISH_MESSAGE);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        ExtentTestManager.flush();
    }
}
