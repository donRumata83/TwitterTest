package Tests;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.assertEquals;


public class DoubleTweetTest extends TestBase {


    @Test
    public void doubleTweetTest() throws Exception{
        app.login();
        app.addTweet("test");
        Thread.sleep(1000);
        app.addTweet("test");
        String expectedMessage = "Ви вже надіслали цей твіт.";
        String actualMessage = app.getTextFromDrawer();

        assertEquals(expectedMessage, actualMessage);
    }
}
