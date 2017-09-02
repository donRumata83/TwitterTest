import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Task01 {
    private static final String URL = "http://www.twitter.com";
    private static final int TIMEOUT = 10000;
    private static final String USER_NAME = "rokachov@gmail.com";
    private static final String USER_PASS = "";
    private static final String TWEET = "Hello world!";
    private static ChromeDriver driver;
    private static WebDriverWait wait;
    private static final By CSS_DRAWER = By.cssSelector("span.message-text");
    private static final String expectedMessage = "Ви вже надіслали цей твіт.";

    @BeforeClass
    public static void begin() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void twitterDoubleTweetCheck() throws InterruptedException {

        driver.get(URL);
        login(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("global-nav-home"))));
        tweet(driver);

        tweet(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message-drawer"))));
        String actualMessage = driver.findElement(CSS_DRAWER).getText();

        assertEquals(actualMessage, expectedMessage);


    }

    @AfterClass
    public static void end() {
        driver.quit();
    }

    private void tweet(WebDriver driver) {
        driver.findElement(By.name("tweet")).sendKeys(TWEET);
        driver.findElement(By.cssSelector("button.tweet-action.EdgeButton.EdgeButton--primary.js-tweet-btn")).click();
    }

    private void login(WebDriver driver) {
        driver.findElement(By.id("signin-email")).sendKeys(USER_NAME);
        driver.findElement(By.id("signin-password")).sendKeys(USER_PASS);
        driver.findElement(By.className("flex-table-secondary")).click();
    }
}
