package googleCloud.pages;

import defaultPage.DefaultPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleCloudCalculatorPage extends DefaultPage {

    @FindBy(xpath = "//iframe[starts-with(@src, '/products')]")
    private WebElement parentFrameLocator;

    @FindBy(id = "myFrame")
    private WebElement childFrameLocator;

    @FindBy(id = "input-0")
    private WebElement searchForAProductLocator;

    @FindBy(xpath = "//span[@class='highlight']/..")
    private List<WebElement> computeEngineLocator;

    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/../input[@name='quantity']")
    private WebElement numberOfInstancesLocator;

    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystemLocator;

    @FindBy(xpath = "//md-option[@value='free']/div[@class='md-text']")
    private WebElement requiredOSValueLocator;

    @FindBy(xpath = "//label[text()='Machine Class']/../md-select")
    private WebElement machineClassLocator;

    @FindBy(xpath = "//md-content/md-option[@value='regular']/div[contains(text(), 'Regular')]")
    private List<WebElement> requiredMachineClassLocator;

    @FindBy(xpath = "//label[text()='Series']/following-sibling::md-select")
    private WebElement seriesLocator;

    @FindBy(xpath = "//md-option[@value='n1']/child::div[@class='md-text ng-binding']")
    private WebElement requiredSeriesLocator;

    @FindBy(xpath = "//label[text()='Machine type']/following-sibling::md-select")
    private WebElement machineTypeLocator;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/" +
            "child::div[@class='md-text ng-binding']")
    private WebElement requiredMachineTypeLocator;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/" +
            "child::div[starts-with(@class, 'md-container')]")
    private WebElement addGPUCheckboxLocator;

    @FindBy(xpath = "//label[text()='Number of GPUs']/../md-select")
    private WebElement gpuCountLocator;

    @FindBy(xpath = "//md-content/md-option[@value='1']/div[contains(text(), '1')]")
    private List<WebElement> requiredGPUCountLocator;

    @FindBy(xpath = "//label[text()='GPU type']/../md-select")
    private WebElement gpuTypeLocator;

    @FindBy(xpath = "//md-content/md-option[@value='NVIDIA_TESLA_V100']/div[contains(text(), 'NVIDIA Tesla V100')]")
    private WebElement requiredGPUTypeLocator;

    @FindBy(xpath = "//label[text()='Local SSD']/../md-select")
    private List<WebElement> localSSDLocator;

    @FindBy(xpath = "//md-content/md-option[@value='2']/div[contains(text(), '2x375 GB')]")
    private WebElement requiredLocalSSDLocator;

    @FindBy(xpath = "//label[text()='Datacenter location']/../md-select")
    private List<WebElement> locationLocator;

    @FindBy(xpath = "//md-content/md-option[@value='europe-west3']/div[contains(text(), 'Frankfurt (europe-west3)')]")
    private List<WebElement> requiredLocationLocator;

    @FindBy(xpath = "//label[text()='Committed usage']/../md-select")
    private List<WebElement> committedUsageLocator;

    @FindBy(xpath = "//md-content/md-option[@value='1']/div[contains(text(), '1 Year')]")
    private List<WebElement> requiredCommittedUsageLocator;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private List<WebElement> addToEstimateButtonLocator;

    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement bodyLocator;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButtonLocator;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmailLocator;

    @FindBy(xpath = "//md-dialog-actions/child::button")
    private List<WebElement> sendEmailButtonLocator;

    /**
     * Result locators
     */

    @FindBy(xpath = "//div[contains(text(), 'regular')]")
    private WebElement vmClassResultLocator;

    @FindBy(xpath = "//div[contains(text(), 'n1-standard-8')]")
    private WebElement instanceTypeResultLocator;

    @FindBy(xpath = "//div[contains(text(), 'Region: Frankfurt')]")
    private WebElement regionResultLocator;

    @FindBy(xpath = "//div[contains(text(), '2x375 GiB')]")
    private WebElement localSSDResultLocator;

    @FindBy(xpath = "//div[contains(text(), 'Commitment term: 1 Year')]")
    private WebElement commitmentTermResultLocator;

    @FindBy(xpath = "//h2[@class='md-title']/child::b[contains(text(), '1,082.77')]")
    private WebElement totalCostResultLocator;

    public GoogleCloudCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void activateComputeEngine() {
        waitForFrameToBeAvailableAndSwitchToIt(parentFrameLocator);
        waitForFrameToBeAvailableAndSwitchToIt(childFrameLocator);
        waitForElementToBeClickable(searchForAProductLocator).click();
        waitForElementToBeClickable(computeEngineLocator.get(0)).click();
        logger.info("Compute Engine activated");
    }

    public void fillForms() {
        waitForElementToBeClickable(numberOfInstancesLocator);
        numberOfInstancesLocator.sendKeys(Keys.NUMPAD4);
        waitForElementToBeClickable(operatingSystemLocator).click();
        waitForElementToBeClickable(requiredOSValueLocator).click();
        waitForElementToBeClickable(machineClassLocator).click();
        waitForElementToBeClickable(requiredMachineClassLocator.get(1)).click();
        waitForElementToBeClickable(seriesLocator).click();
        waitForElementToBeClickable(requiredSeriesLocator).click();
        waitForElementToBeClickable(machineTypeLocator).click();
        waitForElementToBeClickable(requiredMachineTypeLocator).click();
        waitForElementToBeClickable(addGPUCheckboxLocator).click();
        waitForElementToBeClickable(gpuCountLocator).click();
        waitForElementToBeClickable(requiredGPUCountLocator.get(3)).click();
        waitForElementToBeClickable(gpuTypeLocator).click();
        waitForElementToBeClickable(requiredGPUTypeLocator).click();
        waitForElementToBeClickable(localSSDLocator.get(0)).click();
        waitForElementToBeClickable(requiredLocalSSDLocator).click();
        waitForElementToBeClickable(locationLocator.get(0)).click();
        waitForElementToBeClickable(requiredLocationLocator.get(2)).click();
        waitForElementToBeClickable(committedUsageLocator.get(0)).click();
        waitForElementToBeClickable(requiredCommittedUsageLocator.get(1)).click();
        logger.info("Forms filled");
    }

    public void addToEstimate() {
        waitForElementToBeClickable(addToEstimateButtonLocator.get(0)).click();
        logger.info("Added to estimate");
    }

    public void openLinkInNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        logger.info("New tab opened");
    }

    public void emailEstimate() {
        driver.switchTo().activeElement();
        waitForFrameToBeAvailableAndSwitchToIt(parentFrameLocator);
        waitForFrameToBeAvailableAndSwitchToIt(childFrameLocator);
        waitForElementToBeClickable(emailEstimateButtonLocator).click();
    }

    public void enterEmail() {
        try {
            waitForElementToBeClickable(inputEmailLocator).sendKeys((String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor));
            logger.info((String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor));
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        logger.info("Email entered");
    }

    public void sendEmail() {
        waitForElementToBeClickable(sendEmailButtonLocator.get(1)).click();
    }

    public void switchToTenMinuteMail() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("Switched to second tab");
    }

    public boolean isVMClassEqualsToEnteredValue(String term) {
        return vmClassResultLocator.getText().contains(term);
    }

    public boolean isInstanceTypeEqualsToEnteredValue(String term) {
        return instanceTypeResultLocator.getText().contains(term);
    }

    public boolean isRegionEqualsToEnteredValue(String term) {
        return regionResultLocator.getText().contains(term);
    }

    public boolean isLocalSSDEqualsToEnteredValue(String term) {
        return localSSDResultLocator.getText().contains(term);
    }

    public boolean isCommitmentTermEqualsToEnteredValue(String term) {
        return commitmentTermResultLocator.getText().contains(term);
    }

    public boolean isTotalCostEqualsToManualTestResult(String term) {
        return totalCostResultLocator.getText().contains(term);
    }
}