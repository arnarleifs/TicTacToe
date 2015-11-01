package is.ru.tictactoe;

import org.openqa.selenium.remote.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import static org.junit.Assert.assertEquals;

import java.net.URL;

public class SeleniumTest {
    public static final String USERNAME = "arnarleifs";
    public static final String ACCESS_KEY = "6cbcb439-dfa0-4cb5-9f7f-7f5ff1c4ac3c";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static WebDriver driver;

    @BeforeMethod
    public void setupDriver() throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(CapabilityType.PLATFORM, "Windows 8.1");
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://warm-sierra-2216.herokuapp.com/");
    }

    @Test 
    public void testTitle() {
        String title = driver.getTitle();
        assertEquals("Tic tac toe", title);
    }

    @AfterMethod
    public void terminateDriver() {
        driver.quit();
    }
}