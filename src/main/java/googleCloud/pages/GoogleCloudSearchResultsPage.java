package googleCloud.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudSearchResultsPage extends DefaultPage {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator'" +
            "and parent::div[@class='gs-title']]/b")
    private WebElement calculatorPageLocator;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToCalculatorPage() {
        waitForElementToBeClickable(calculatorPageLocator).click();
        logger.info("Switched to google cloud calculator page");
    }
}