package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.CareersPage;

public class CareersPageSteps {

    CareersPage careersPage = new CareersPage();

    @Given("User is on the Insider One Open Roles page")
    public void userIsOnTheInsiderOneHomePage() throws InterruptedException {
        careersPage.openOpenRolesPage();
    }

    @And("Click on See All Teams button on Open Roles page")
    public void clickOnSeeAllTeamsButtonOnOpenRolesPage() {
        careersPage.clickOnSeeAllTeamsButton();
    }

    @And("Click on Quality Assurance button on Open Roles page")
    public void clickOnQualityAssuranceButtonOnOpenRolesPage() {
        careersPage.clickOnQualityAssuranceButton();
    }
}
