package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getRootLogger();

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = DriverManager.getInstance().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.getInstance().closeDriver();
    }
}