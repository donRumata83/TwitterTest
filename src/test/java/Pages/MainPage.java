package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Page {
    private String url;

    public MainPage(WebDriver driver, String url) {
        super(driver);

        this.url = url;
    }

    public void tweet(String text) {
        driver.findElement(By.name("tweet")).sendKeys(text);
        driver.findElement(By.cssSelector("button.tweet-action.EdgeButton.EdgeButton--primary.js-tweet-btn")).click();
    }

    public void open() {
        driver.get(url);
    }

    public String getTextFromDrawer() {
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message-drawer"))));
        return driver.findElement(By.cssSelector("span.message-text")).getText();
    }
}
