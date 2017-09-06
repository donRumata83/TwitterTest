package Tests;

import Application.Browser;
import org.junit.Test;
;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DeleteTweetTest extends TestBase {

    @Test
    public void deleteTweet() {
        app.setBrowser(Browser.CHROME);
        app.login();
        String before = app.getLastTweetText();
        app.deleteTweet();
        String after = app.getLastTweetText();

        assertThat(before, is(not(equalTo(after))));
    }
}
