package Application;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.Profile;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    private WebDriver driver;

    private LoginPage loginPage;
    private MainPage mainPage;
    private Profile profilePage;

    private String URL;
    private String USER;
    private String LOGIN;
    private String PASS;


    public Application() {
        this.URL = "http://www.twitter.com";
        this.USER = "donrumatadon";
        this.LOGIN = "rokachov@gmail.com";
        this.PASS = "";

        ChromeDriverManager.getInstance().setup();
        this.driver = new ChromeDriver();

        this.loginPage = new LoginPage(driver, URL);
        this.mainPage = new MainPage(driver, URL);
        this.profilePage = new Profile(driver,URL, USER);
    }

    public void login() {
        loginPage.open();
        loginPage.login(LOGIN, PASS);
    }

    public void addTweet(String text) {
        mainPage.open();
        mainPage.tweet(text);
    }

    public void deleteTweet() {
        profilePage.open();
        profilePage.deleteTweet();
    }

    public void quit() {
        driver.quit();
    }

    public String getTextFromDrawer() {
        return mainPage.getTextFromDrawer();
    }

    public String getLastTweetText() {
        profilePage.open();
        return profilePage.getTextFromFirstTweet();
    }
}
