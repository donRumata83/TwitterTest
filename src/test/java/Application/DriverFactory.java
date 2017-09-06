package Application;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

    public WebDriver getWebDriver(Browser browser) {
        WebDriver result;
        switch (browser) {
            case CHROME: {
                ChromeDriverManager.getInstance().setup();
                result = new ChromeDriver();
                break;
            }
            case FF: {
                FirefoxDriverManager.getInstance().setup();
                result = new FirefoxDriver();
                break;
            }
            case IE: {
                InternetExplorerDriverManager.getInstance().setup();
                result = new InternetExplorerDriver();
                break;
            }
            case OPERA: {
                OperaDriverManager.getInstance().setup();
                result = new OperaDriver();
                break;
            }
            default:
                InternetExplorerDriverManager.getInstance().setup();
                result = new InternetExplorerDriver();
        }

        return result;
    }
}
