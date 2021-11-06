package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import java.lang.reflect.InvocationTargetException;

public class VerifyLoginPage extends BaseTest {

    @Test
    public void verifyLoginPageElementsTest() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        page.getInstance(LoginPage.class).checkLogo();
        page.getInstance(LoginPage.class).checkUsernameField();
        page.getInstance(LoginPage.class).checkPasswordField();
        page.getInstance(LoginPage.class).checkLoginButton();
    }

    @Test
    public void verifyLoginTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        page.getInstance(LoginPage.class).checkLoginSuccessfully();
    }

    @Test
    public void verifyInvalidLoginTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        page.getInstance(LoginPage.class).doLogin("stan", "secret_sauce");
        page.getInstance(LoginPage.class).checkLoginError("Epic sadface: Username and password do not match any user in this service");
    }
}
