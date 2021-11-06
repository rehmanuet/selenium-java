package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;


public class Page {
    public WebDriver driver;
    public WebDriverWait wait;

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
    }
}
