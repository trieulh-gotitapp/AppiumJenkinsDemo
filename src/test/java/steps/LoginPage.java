package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private RemoteWebDriver driver;

    @FindBy(id = "com.quikr:id/continue_login")
    private WebElement btnContinue;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/TextInputLayout/android.widget.LinearLayout/android.widget.TextView")
    private WebElement textError;

    public LoginPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.visibilityOf(btnContinue));
        btnContinue.click();
    }

    public String getErrorText() {
        waitForElementToBeVisible(textError);
        return textError.getText();
    }
}
