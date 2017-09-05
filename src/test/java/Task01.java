import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Task01 {
    private static final String URL = "http://www.twitter.com";
    private static final String USER_NAME = "donrumatadon";
    private static final int TIMEOUT = 10000;
    private static final String USER_LOGIN = "rokachov@gmail.com";
    private static final String USER_PASS = "";
    private static final String TWEET = "Hello world!";
    private static ChromeDriver driver;
    private static WebDriverWait wait;
    private static final By CSS_DRAWER = By.cssSelector("span.message-text");
    private static final String expectedMessage = "Ви вже надіслали цей твіт.";

    @BeforeClass
    public static void begin() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        login(URL, USER_LOGIN, USER_PASS);
    }

    @Before
    public void beforeTest() {

        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void twitterDoubleTweetCheck() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("global-nav-home"))));
        tweet(driver, TWEET);
        Thread.sleep(TIMEOUT);
        tweet(driver, TWEET);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message-drawer"))));
        String actualMessage = driver.findElement(CSS_DRAWER).getText();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void getAlltweetsList() {

        assertTrue(getAllTweets(driver, URL, USER_NAME).size() != 0);
    }

    @Test
    public void deleteFirstTweet() {
        String textFromFirstTweet = getFirstTweetText();
        System.out.println(textFromFirstTweet);
        deleteTweet(driver);
        String actualFirstTweetText = getFirstTweetText();
        assertTrue(!textFromFirstTweet.equals(actualFirstTweetText));
    }

    @AfterClass
    public static void end() {
        driver.quit();
    }

    private void tweet(WebDriver driver, String tweet) {
        driver.findElement(By.name("tweet")).sendKeys(tweet);
        driver.findElement(By.cssSelector("button.tweet-action.EdgeButton.EdgeButton--primary.js-tweet-btn")).click();
    }

    private static void login(String URL, String userName, String pass) {
        driver.get(URL);
        driver.findElement(By.id("signin-email")).sendKeys(userName);
        driver.findElement(By.id("signin-password")).sendKeys(pass);
        driver.findElement(By.className("flex-table-secondary")).click();
    }

    private void deleteTweet(WebDriver driver) {
        driver.get(URL + "/" + USER_NAME);
        for (WebElement element : getAllTweets(driver, URL, USER_NAME)) {

            element.findElement(By.cssSelector("div.dropdown")).click();
            if (element.findElement(By.cssSelector("li.js-actionDelete")).isEnabled()) {
                element.findElement(By.cssSelector("li.js-actionDelete")).click();
                driver.findElement(By.cssSelector("button.EdgeButton.EdgeButton--danger.delete-action")).click();
                break;
            }

        }
    }

    private List<WebElement> getAllTweets(WebDriver driver, String URL, String USER_NAME) {
        driver.get(URL + "/" + USER_NAME);
        List<WebElement> result = driver.findElements(By.cssSelector("div.tweet"));
        return result;
    }


    private String getFirstTweetText() {
        driver.get(URL + "/" + USER_NAME);

        return getAllTweets(driver, URL, USER_NAME).get(0).findElement(By.cssSelector("div.js-tweet-text-container")).getText();

    }
}
