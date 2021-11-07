package pages;

import com.relevantcodes.extentreports.LogStatus;
import extent.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Implementation of the Base Page Class for the generic selenium methods used in test cases
 *
 * @author Abdur.Rehman
 */

public class BasePage extends Page {
    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void doSendKeys(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public String doGetText(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            boolean displayedStatus = driver.findElement(locator).isDisplayed();
            ExtentTestManager.getTest().log(LogStatus.INFO, locator.toString() + " : " + displayedStatus);
            return displayedStatus;
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
