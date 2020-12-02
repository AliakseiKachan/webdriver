package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverManager {

    private static final String BROWSER = "";
    private static DriverManager instance = null;
    private static WebDriver driver;

    private DriverManager() {}

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void closeDriver() {
        driver.quit();
        driver = null;
    }
}