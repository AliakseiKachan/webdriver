package googleCloud;

import base.BaseTest;
import googleCloud.pages.GoogleCloudCalculatorPage;
import googleCloud.pages.GoogleCloudHomePage;
import googleCloud.pages.GoogleCloudSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import tenMinuteMail.pages.TenMinuteMailHomePage;

public class GoogleCloudTest extends BaseTest {

    private final String ENTERED_SEARCH_TERM = "Google Cloud Platform Pricing Calculator";
    private final String REQUIRED_TOTAL_COST = "1,082.77";

    @Test
    public void areResultsEqualsToRequiredTest() {
        logger.info("areResultsEqualsToRequiredTest started");
        String vmClass = "regular";
        String instanceType = "n1-standard-8";
        String region = "Frankfurt";
        String localSSD = "2x375 GiB";
        String commitmentTerm = "1 Year";
        GoogleCloudHomePage cloudHomePage = new GoogleCloudHomePage(driver);
        GoogleCloudSearchResultsPage cloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        GoogleCloudCalculatorPage cloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        cloudHomePage.openPage();
        cloudHomePage.enterSearchTerm(ENTERED_SEARCH_TERM);
        cloudHomePage.runSearch();
        cloudSearchResultsPage.goToCalculatorPage();
        cloudCalculatorPage.activateComputeEngine();
        cloudCalculatorPage.fillForms();
        cloudCalculatorPage.addToEstimate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cloudCalculatorPage.isVMClassEqualsToEnteredValue(vmClass),
                "VM Class isn't equal to entered value!");
        softAssert.assertTrue(cloudCalculatorPage.isInstanceTypeEqualsToEnteredValue(instanceType),
                "Instance type isn't equal to entered value!");
        softAssert.assertTrue(cloudCalculatorPage.isRegionEqualsToEnteredValue(region),
                "Region isn't equal to entered value!");
        softAssert.assertTrue(cloudCalculatorPage.isLocalSSDEqualsToEnteredValue(localSSD),
                "Local SSD isn't equal to entered value!");
        softAssert.assertTrue(cloudCalculatorPage.isCommitmentTermEqualsToEnteredValue(commitmentTerm),
                "Commitment term isn't equal to entered value!");
        softAssert.assertTrue(cloudCalculatorPage.isTotalCostEqualsToManualTestResult(REQUIRED_TOTAL_COST),
                "Total cost isn't equal to result received by manual test!");
        logger.info("areResultsEqualsToRequiredTest finished");
        softAssert.assertAll();
    }

    @Test
    public void isTotalEstimatedMonthlyCostInEmailEqualsToRequiredTest() {
        logger.info("isTotalEstimatedMonthlyCostInEmailEqualsToRequiredTest started");
        GoogleCloudHomePage cloudHomePage = new GoogleCloudHomePage(driver);
        GoogleCloudSearchResultsPage cloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        GoogleCloudCalculatorPage cloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        TenMinuteMailHomePage tenMinuteMailHomePage = new TenMinuteMailHomePage(driver);
        cloudHomePage.openPage();
        cloudHomePage.enterSearchTerm(ENTERED_SEARCH_TERM);
        cloudHomePage.runSearch();
        cloudSearchResultsPage.goToCalculatorPage();
        cloudCalculatorPage.activateComputeEngine();
        cloudCalculatorPage.fillForms();
        cloudCalculatorPage.addToEstimate();
        cloudCalculatorPage.openLinkInNewTab();
        tenMinuteMailHomePage.copyEmail();
        tenMinuteMailHomePage.switchToCalculator();
        cloudCalculatorPage.emailEstimate();
        cloudCalculatorPage.enterEmail();
        cloudCalculatorPage.sendEmail();
        cloudCalculatorPage.switchToTenMinuteMail();
        tenMinuteMailHomePage.openMailMessage();
        logger.info("isTotalEstimatedMonthlyCostInEmailEqualsToRequiredTest finished");
        Assert.assertTrue(tenMinuteMailHomePage.isTotalCostInEmailEqualsToRequired(REQUIRED_TOTAL_COST));
    }
}