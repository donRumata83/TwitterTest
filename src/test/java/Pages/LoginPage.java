package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private String url;
    private String login;
    private String pass;

    public LoginPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    public void login(String login, String pass) {
        this.login = login;
        this.pass = pass;
        driver.findElement(By.id("signin-email")).sendKeys(this.login);
        driver.findElement(By.id("signin-password")).sendKeys(this.pass);
        driver.findElement(By.className("flex-table-secondary")).click();
    }

    public void open() {
        driver.get(url);
    }
}
