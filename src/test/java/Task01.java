import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Task01 {
    private static final String URL = "http://www.twitter.com";
    private static final int TIMEOUT = 100000;
    private static final String USER_NAME = "rokachov@gmail.com";
    private static final String USER_PASS = "Rumata3330592";

    @BeforeClass
    public static void begin() {
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void chromeTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id("signin-email")).sendKeys(USER_NAME);
        driver.findElement(By.id("signin-password")).sendKeys(USER_PASS);
        driver.findElement(By.className("flex-table-secondary")).click();
        Thread.sleep(TIMEOUT);


        driver.quit();

    }
}
