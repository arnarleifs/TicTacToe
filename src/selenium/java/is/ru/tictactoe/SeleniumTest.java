package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.URL;

public class SeleniumTest {
    public static WebDriver driver;
    public static String herokuUrl = "https://warm-sierra-2216.herokuapp.com/";

    @BeforeClass
    public static void before() throws Exception {  
        driver = new FirefoxDriver();
        driver.get(herokuUrl);
    }

    @After
    public void goToMain() {
        driver.get(herokuUrl);
    }

    @Test
    public void testTitle() {
        driver.get(herokuUrl);
        String jumbotron = driver.findElement(By.cssSelector(".jumbotron")).getText();
        assertEquals("Tic tac toe!", jumbotron);
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }

}
