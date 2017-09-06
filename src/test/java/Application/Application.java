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

    private String url;
    private String user;
    private String login;
    private String pass;


    public Application() {
        this.url = "http://www.twitter.com";
        this.user = "donrumatadon";
        this.login = "rokachov@gmail.com";
        this.pass = "";

        ChromeDriverManager.getInstance().setup();
        this.driver = new ChromeDriver();

        this.loginPage = new LoginPage(driver, url);
        this.mainPage = new MainPage(driver, url);
        this.profilePage = new Profile(driver, url, user);
    }

    public void login() {
        loginPage.open();
        loginPage.login(login, pass);
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
