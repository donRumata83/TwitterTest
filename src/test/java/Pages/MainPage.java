package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    private String URL;

    public MainPage(WebDriver driver, String URL) {
        super(driver);

        this.URL = URL;
    }

    public void tweet(String text) {
        driver.findElement(By.name("tweet")).sendKeys(text);
        driver.findElement(By.cssSelector("button.tweet-action.EdgeButton.EdgeButton--primary.js-tweet-btn")).click();
    }
}
