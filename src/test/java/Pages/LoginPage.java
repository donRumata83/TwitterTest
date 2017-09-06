package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private String URL;
    private String LOGIN;
    private String PASS;

    public LoginPage(WebDriver driver, String URL) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.URL = URL;
    }

    public void login(String login, String pass) {
        this.LOGIN = login;
        this.PASS = pass;
        driver.findElement(By.id("signin-email")).sendKeys(LOGIN);
        driver.findElement(By.id("signin-password")).sendKeys(PASS);
        driver.findElement(By.className("flex-table-secondary")).click();
    }

    public void open() {
        driver.get(URL);
    }
}
