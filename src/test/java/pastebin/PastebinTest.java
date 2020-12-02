package pastebin;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pastebin.pages.PastebinHomePage;
import pastebin.pages.PastebinNewPastePage;

public class PastebinTest extends BaseTest {

    @Test
    public void isNewPasteCreatedTest() {
        String enteredCodeICanWin = "Hello from WebDriver";
        String enteredPasteNameICanWin = "helloweb";
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        PastebinNewPastePage pastebinNewPastePage = new PastebinNewPastePage(driver);
        pastebinHomePage.openPage();
        pastebinHomePage.enterCode(enteredCodeICanWin);
        pastebinHomePage.enterPasteExpirationTime();
        pastebinHomePage.enterPasteName(enteredPasteNameICanWin);
        pastebinHomePage.createNewPaste();
        Assert.assertTrue(pastebinNewPastePage.isNewPasteCreated(enteredPasteNameICanWin));
    }

    @Test
    public void areResultsEqualsToExpectedTest() {
        String enteredCodeBringItOn = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String enteredPasteNameBringItOn = "how to gain dominance among developers";
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        PastebinNewPastePage pastebinNewPastePage = new PastebinNewPastePage(driver);
        pastebinHomePage.openPage();
        pastebinHomePage.enterCode(enteredCodeBringItOn);
        pastebinHomePage.enterSyntaxHighlightingType();
        pastebinHomePage.enterPasteExpirationTime();
        pastebinHomePage.enterPasteName(enteredPasteNameBringItOn);
        pastebinHomePage.createNewPaste();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pastebinNewPastePage.isPageTitleEqualsToPasteName(enteredPasteNameBringItOn),
                "Page title isn't equal to paste name!");
        softAssert.assertTrue(pastebinNewPastePage.isBashHighlightingTypePresent(),
                "Bash highlighting type isn't present!");
        softAssert.assertTrue(pastebinNewPastePage.isTextInTextAreaEqualsEnterCode(enteredCodeBringItOn),
                "Text in text area isn't equal enter code!");
        softAssert.assertAll();
    }
}