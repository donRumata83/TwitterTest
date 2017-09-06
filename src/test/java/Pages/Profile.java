package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Profile extends Page {
    private String URL;
    private String USERNAME;

    public Profile(WebDriver driver, String URL, String USERNAME) {
        super(driver);
        this.URL = URL;
        this.USERNAME = USERNAME;
    }

    private List<WebElement> getListOfTweets() {
        return driver.findElements(By.cssSelector("div.tweet"));
    }

    public String getTextFromFirstTweet() {
        return getListOfTweets().get(0).findElement(By.cssSelector("div.js-tweet-text-container")).getText();
    }

    public void open() {
        driver.get(URL + "/" + USERNAME);
    }

    public void deleteTweet() {
        for (WebElement element : getListOfTweets()) {
            element.findElement(By.cssSelector("div.dropdown")).click();
            if (element.findElement(By.cssSelector("li.js-actionDelete")).isEnabled()) {
                element.findElement(By.cssSelector("li.js-actionDelete")).click();
                driver.findElement(By.cssSelector("button.EdgeButton.EdgeButton--danger.delete-action")).click();
                break;
            }

        }
    }
}
