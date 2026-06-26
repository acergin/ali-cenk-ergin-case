package stepdefinitions;

import constants.DemoRequestPageConstants;
import io.cucumber.java.en.Then;
import pages.DemoRequestPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoRequestPageSteps {

    private final DemoRequestPage demoRequestPage = new DemoRequestPage();

    @Then("Demo request page should be displayed")
    public void demoRequestPageShouldBeDisplayed() {
        demoRequestPage.waitUntilLoaded();

        assertThat(demoRequestPage.getCurrentUrlPath()).contains(DemoRequestPageConstants.REQUEST_DEMO_PATH);
        assertThat(demoRequestPage.getDocumentTitle()).isEqualTo(DemoRequestPageConstants.EXPECTED_PAGE_TITLE);
        assertThat(demoRequestPage.getPageHeading()).isEqualTo(DemoRequestPageConstants.EXPECTED_HEADING);
        assertThat(demoRequestPage.getFormSectionTitle())
                .isEqualTo(DemoRequestPageConstants.EXPECTED_FORM_SECTION_TITLE);
        assertThat(demoRequestPage.isDemoFormDisplayed()).isTrue();
        assertThat(demoRequestPage.getSubmitButtonText())
                .isEqualTo(DemoRequestPageConstants.EXPECTED_SUBMIT_BUTTON_TEXT);
    }
}
