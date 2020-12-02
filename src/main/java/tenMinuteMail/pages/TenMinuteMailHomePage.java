package tenMinuteMail.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class TenMinuteMailHomePage extends DefaultPage {

    @FindBy(id = "mail_address")
    private WebElement copyEmailLocator;

    @FindBy(className = "message_top")
    private WebElement messageLocator;

    @FindBy(xpath = "//h2[contains(text(), '1,082.77')]")
    private WebElement totalCostInEmailLocator;

    public TenMinuteMailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void copyEmail() {
        waitForElementToBeClickable(copyEmailLocator).sendKeys(Keys.CONTROL + "c");
        waitForElementToBeClickable(copyEmailLocator).sendKeys(Keys.CONTROL + "c");
        waitForElementToBeClickable(copyEmailLocator).sendKeys(Keys.CONTROL + "c");
        waitForElementToBeClickable(copyEmailLocator).sendKeys(Keys.CONTROL + "c");
        waitForElementToBeClickable(copyEmailLocator).sendKeys(Keys.CONTROL + "c");
        logger.info("Email address copied");
    }

    public void switchToCalculator() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void openMailMessage() {
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .visibilityOf(messageLocator)).click();
        logger.info("Email message opened");
    }

    public boolean isTotalCostInEmailEqualsToRequired(String term) {
        return totalCostInEmailLocator.getText().contains(term);
    }
}