package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Implementation of the page layer for the Inventory Page
 */

public class InventoryPage extends BasePage {

    By badge = By.className("shopping_cart_badge");
    By sortButton = By.className("product_sort_container");
    By cartButton = By.className("shopping_cart_link");
    By menuButton = By.className("bm-burger-button");
    By productTitle = By.className("title");
    By removeButton = By.id("remove-sauce-labs-backpack");

    By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkSortButton() {
        Assert.assertTrue(isVisible(sortButton), "Sort Button is not displayed");
    }

    public void checkProductTitle() {
        Assert.assertTrue(isVisible(productTitle), "Product Title is not displayed");
    }

    public void checkCartButton() {
        Assert.assertTrue(isVisible(cartButton), "Cart Button is not displayed");
    }

    public void checkMenuButton() {
        Assert.assertTrue(isVisible(menuButton), "Menu button is not displayed");
    }

    public void addProductToCart() {
        isVisible(addBackpackButton);
        click(addBackpackButton);
        Assert.assertFalse(isVisible(addBackpackButton), "Product is not added into cart");
        String badgeCount = doGetText(badge);
        Assert.assertEquals(badgeCount, "1");
    }

    public void removeProductFromCart() {
        isVisible(removeButton);
        click(removeButton);
        Assert.assertFalse(isVisible(badge), "1");
    }
}

