package pastebin.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PastebinNewPastePage extends DefaultPage {

    @FindBy(tagName = "h1")
    private WebElement pageTitleICanWin;

    @FindBy(tagName = "title")
    private List<WebElement> pageTitleBringItOn;

    @FindBy(className = "bash")
    private WebElement bashHighlightingType;

    @FindBy(className = "textarea")
    private WebElement textArea;

    public PastebinNewPastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isNewPasteCreated(String term) {
        waitForPresenceOfElementLocated(By.tagName("h1"));
        return term.contains(pageTitleICanWin.getText());
    }

    public boolean isPageTitleEqualsToPasteName(String term) {
        waitForPresenceOfElementLocated(By.tagName("title"));
        return term.contains(pageTitleBringItOn.get(0).getText());
    }

    public boolean isBashHighlightingTypePresent() {
        waitForPresenceOfElementLocated(By.className("bash"));
        return bashHighlightingType.isDisplayed();
    }

    public boolean isTextInTextAreaEqualsEnterCode(String term) {
        waitForPresenceOfElementLocated(By.className("textarea"));
        return term.contains(textArea.getText());
    }
}