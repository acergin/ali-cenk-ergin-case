package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LeverJobsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LeverJobsPageSteps {

    LeverJobsPage leverJobsPage = new LeverJobsPage();

    @Then("Verify QA Jobs List is displayed")
    public void verifyJobsListIsDisplayed() {
        assertThat(leverJobsPage.isApplyButtonsDisplayed()).isTrue();
        assertThat(leverJobsPage.getJobTitles().stream().allMatch(jobTitle -> jobTitle.toLowerCase().contains("qa")
                || jobTitle.toLowerCase().contains("quality assurance"))).isTrue();
    }

    @And("Verify all jobs' department is {string}")
    public void verifyAllJobsDepartmentIs(String department) {
        assertThat(leverJobsPage.getAllJobDepartments()).allMatch(item -> item.equals(department));
    }

    @When("Open first job and click on Apply For This Job button")
    public void openFirstJobAndClickOnApplyForThisJobButton() {
        leverJobsPage.openFirstJob();
        leverJobsPage.clickOnApplyForThisJobButton();
    }

    @Then("Verify user is redirected to Lever Application form page")
    public void verifyUserIsRedirectedToLeverApplicationFormPage() {
        assertThat(leverJobsPage.isLeverApplicationPageOpened()).isTrue();
    }
}
