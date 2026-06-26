package pages;

import constants.DemoRequestPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DemoRequestPage extends BasePage {

    public DemoRequestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h1.demo_h1")
    private WebElement pageHeading;

    @FindBy(css = "h2.dem_title")
    private WebElement formSectionTitle;

    @FindBy(css = "#expandable-form .hbspt-form form")
    private WebElement hubspotForm;

    @FindBy(css = "#expandable-form input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "#expandable-form select[name='industry_dropdown']")
    private WebElement industryDropdown;

    @FindBy(css = "#expandable-form input[type='submit'].hs-button")
    private WebElement submitButton;

    public void waitUntilLoaded() {
        waitForUrlContains(DemoRequestPageConstants.REQUEST_DEMO_PATH);
        waitForPageLoad();
        waitForTitleContains("Get a demo");
        waitVisible(pageHeading);
        waitVisible(formSectionTitle);
        waitForDemoFormReady();
    }

    private void waitForDemoFormReady() {
        waitVisible(hubspotForm);
        waitVisible(emailInput);
        waitVisible(industryDropdown);
        waitVisible(submitButton);
    }

    public String getPageHeading() {
        return getText(pageHeading);
    }

    public String getFormSectionTitle() {
        return getText(formSectionTitle);
    }

    public String getSubmitButtonText() {
        return getAttribute(submitButton, "value");
    }

    public boolean isDemoFormDisplayed() {
        try {
            return isDisplayed(hubspotForm)
                    && isDisplayed(emailInput)
                    && isDisplayed(industryDropdown)
                    && isDisplayed(submitButton);
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentUrlPath() {
        return getCurrentUrl();
    }

    public String getDocumentTitle() {
        return getPageTitle();
    }
}
