package tests;

import com.relevantcodes.extentreports.LogStatus;
import extent.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

import static utils.Constants.VALID_PASSWORD;
import static utils.Constants.VALID_USERNAME;

public class VerifyInventoryPage extends BaseTest {

    @Test
    public void tc004_verifyInventoryPageElements() {
        ExtentTestManager.startTest("TC004-VerifyInventoryPageElements", "Verification of Inventory Page elements");
        try {
            page.getInstance(LoginPage.class).doLogin(VALID_USERNAME, VALID_PASSWORD);
            page.getInstance(InventoryPage.class).checkProductTitle();
            page.getInstance(InventoryPage.class).checkMenuButton();
            page.getInstance(InventoryPage.class).checkCartButton();
            page.getInstance(InventoryPage.class).checkSortButton();
            ExtentTestManager.getTest().log(LogStatus.PASS, "All elements are displayed");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }

    @Test
    public void tc005_verifyAddProductToCart() {
        ExtentTestManager.startTest("TC005-VerifyAddProductToCart", "Verification of adding the product into cart");
        try {
            page.getInstance(LoginPage.class).doLogin(VALID_USERNAME, VALID_PASSWORD);
            page.getInstance(InventoryPage.class).addProductToCart();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Product is added into Cart");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }

    @Test
    public void tc006_verifyRemoveProductFromCart() {
        ExtentTestManager.startTest("TC006-VerifyRemoveProductFromCart", "Verification of removing the product into cart");
        try {
            page.getInstance(LoginPage.class).doLogin(VALID_USERNAME, VALID_PASSWORD);
            page.getInstance(InventoryPage.class).addProductToCart();
            page.getInstance(InventoryPage.class).removeProductFromCart();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Product is removed from the cart");
        } catch (AssertionError | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException error) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, error.getMessage());
            Assert.fail(error.getMessage());
        }
    }
}
