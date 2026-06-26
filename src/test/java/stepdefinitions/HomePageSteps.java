package stepdefinitions;

import constants.HomePageConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("User is on the Insider One home page")
    public void userIsOnTheInsiderOneHomePage() {
        homePage.openHomePage();
    }

    @Then("Insider home page should be displayed")
    public void insiderHomePageShouldBeDisplayed() {
        assertThat(homePage.isHomePageOpened()).isTrue();
    }

    @And("Verify all home page sections are displayed")
    public void verifyAllHomePageSectionsAreDisplayed() {
        assertThat(homePage.getSections()).containsExactlyInAnyOrderElementsOf(HomePageConstants.EXPECTED_SECTIONS);
    }

    @And("Verify header is displayed")
    public void verifyHeaderIsDisplayed() {
        assertThat(homePage.getHeaderTopItems()).containsExactlyInAnyOrderElementsOf(HomePageConstants.EXPECTED_HEADER_TOP_ITEMS);
        assertThat(homePage.isHeaderTopActionsDisplayed()).isTrue();
        assertThat(homePage.getHeaderItems()).containsExactlyInAnyOrderElementsOf(HomePageConstants.EXPECTED_HEADER_ITEMS);
        assertThat(homePage.getHeaderActions()).containsExactlyInAnyOrderElementsOf(HomePageConstants.EXPECTED_HEADER_ACTIONS);
    }

    @And("Verify footer is displayed")
    public void verifyFooterIsDisplayed() {
        assertThat(homePage.isFooterDisplayed()).isTrue();
    }

    @When("User clicks on Get a demo in the header")
    public void userClicksOnGetDemoInTheHeader() {
        homePage.clickGetDemoButton();
    }
}
