package Application;

public enum Browser {
    CHROME,
    IE,
    OPERA,
    FF;

    public static Browser getBrowser(String browser) {
        switch (browser) {
            case "chrome":
                return Browser.CHROME;

            case "ff":
                return Browser.FF;

            case "opera":
                return Browser.OPERA;

            default:
                return Browser.IE;
        }
    }
}
