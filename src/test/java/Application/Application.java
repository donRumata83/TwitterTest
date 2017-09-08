package Application;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.Profile;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


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
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("C:/JavaProjects/TwitterTest/config.properties"));
            this.url = props.getProperty("URL");
            this.user = props.getProperty("user_name");
            this.login = props.getProperty("login");
            this.pass = props.getProperty("pass");
            this.driver = new DriverFactory().getWebDriver(props.getProperty("browser"));
            this.loginPage = new LoginPage(driver, url);
            this.mainPage = new MainPage(driver, url);
            this.profilePage = new Profile(driver, url, user);
        } catch (IOException e) {}


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
