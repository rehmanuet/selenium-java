package tests;

import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

public class VerifyInventoryPage extends BaseTest {

    @Test
    public void verifyInventoryPageElementsTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        page.getInstance(InventoryPage.class).checkProductTitle();
        page.getInstance(InventoryPage.class).checkMenuButton();
        page.getInstance(InventoryPage.class).checkCartButton();
        page.getInstance(InventoryPage.class).checkSortButton();

    }

    @Test
    public void verifyAddProductToCartTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        page.getInstance(InventoryPage.class).addProductToCart();
    }

    @Test
    public void verifyRemoveProductToCartTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        page.getInstance(InventoryPage.class).addProductToCart();
        page.getInstance(InventoryPage.class).removeProductToCart();
    }
}
