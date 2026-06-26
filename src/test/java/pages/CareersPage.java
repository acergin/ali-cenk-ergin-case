package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class CareersPage extends BasePage {

    private final HomePage homePage = new HomePage();

    public CareersPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[.='See all teams ']")
    private WebElement seeAllTeamsButton;

    @FindBy(css = "div[data-department='Quality Assurance'] a")
    private WebElement qualityAssuranceButton;

    public void openOpenRolesPage() throws InterruptedException {
        navigateTo(ConfigReader.get("openRolesUrl"));
        homePage.acceptCookiesIfPresent();
    }

    public void clickOnSeeAllTeamsButton() {
        click(seeAllTeamsButton);
    }

    public void clickOnQualityAssuranceButton() {
        waitUntilTextDoesNotContain(qualityAssuranceButton, "0 Open Positions");
        click(qualityAssuranceButton);
    }
}
