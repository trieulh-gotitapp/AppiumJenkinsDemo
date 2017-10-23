package steps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LogInTest {

    private RemoteWebDriver driver;

    @Before
    public void setupTest() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "5X-8.0");
        capabilities.setCapability("avd", "5X-8.0");
        capabilities.setCapability("avdReadyTimeout", 180000);

//        capabilities.setCapability("app", "/Users/gotit/Projects/AutomationTestingHelloAppium/app/quikr.apk");
        capabilities.setCapability("appPackage", "com.quikr");
        capabilities.setCapability("appActivity", "com.quikr.old.SplashActivity");

        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("browser", "Chrome");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public void closeAppiumServerSession() {
        driver.quit();
    }

    @Test
    public void testClickContinue() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.getErrorText().equals("Please enter your email or mobile number"));
    }
}
