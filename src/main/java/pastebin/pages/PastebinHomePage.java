package pastebin.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PastebinHomePage extends DefaultPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingTypeNone;

    @FindBy(xpath = "//li[starts-with(@class, 'select2-results__option') and text()='Bash']")
    private List<WebElement> syntaxHighlightingTypeBash;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationTimeNever;

    @FindBy(xpath = "//li[starts-with(@class, 'select2-results__option') and text()='10 Minutes']")
    private WebElement pasteExpirationTime10Minutes;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void enterCode(String term) {
        waitForElementToBeClickable(codeInput).sendKeys(term);
    }

    public void enterSyntaxHighlightingType() {
        waitForElementToBeClickable(syntaxHighlightingTypeNone).click();
        waitForElementToBeClickable(syntaxHighlightingTypeBash.get(0)).click();
    }

    public void enterPasteExpirationTime() {
        waitForElementToBeClickable(pasteExpirationTimeNever).click();
        waitForElementToBeClickable(pasteExpirationTime10Minutes).click();
    }

    public void enterPasteName(String term) {
        waitForElementToBeClickable(pasteNameInput).sendKeys(term);
    }

    public void createNewPaste() {
        waitForElementToBeClickable(createNewPasteButton).click();
    }
}