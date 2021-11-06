package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    By productTitle = By.className("title");
    By sortButton = By.className("product_sort_container");
    By cartButton = By.className("shopping_cart_link");
    By menuButton = By.className("bm-burger-button");
    By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    By badge = By.className("shopping_cart_badge");
    By removeButton = By.id("remove-sauce-labs-backpack");

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
        Assert.assertFalse(isVisible(addBackpackButton), "Menu button is not displayed");
        String badgeCount = doGetText(badge);
        Assert.assertEquals(badgeCount, "1");
    }


    public void removeProductToCart() {
        isVisible(removeButton);
        click(removeButton);
        Assert.assertFalse(isVisible(badge), "1");
    }
}

