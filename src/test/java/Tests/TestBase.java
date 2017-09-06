package Tests;

import Application.Application;
import org.junit.BeforeClass;

public class TestBase {
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public static Application app;

    @BeforeClass
    public static void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    app.quit();
                    app = null;
                }));
    }
}
