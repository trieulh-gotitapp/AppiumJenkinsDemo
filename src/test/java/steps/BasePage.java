package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private RemoteWebDriver driver;
    WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) throws Exception{
        this.driver = driver;
        wait = new WebDriverWait(this.driver,30);
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
