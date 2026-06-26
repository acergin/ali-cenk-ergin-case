package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class LeverJobsPage extends BasePage {

    public LeverJobsPage() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = "div[class='postings-group']")
    private WebElement jobsList;

    @FindBy(css = "div[class='posting']")
    private List<WebElement> jobs;

    @FindBy(xpath = "//div[contains(@class,'department')]")
    private WebElement department;

    @FindBy(xpath = "//a[contains(@class,'postings-btn') and contains(@class,'submit')]")
    private WebElement applyForThisJobButton;

    public boolean isApplyButtonsDisplayed() {
        for (WebElement job : jobs) {
            if (!isDisplayed(job.findElement(By.xpath("./div/a[.='Apply']")))) {
                return false;
            }
        }
        return true;
    }

    public List<String> getJobTitles() {
        return jobs.stream().map(e -> e.findElement(By.cssSelector("a > h5")).getText()).toList();
    }

    public List<String> getAllJobDepartments() {
        List<String> departments = new ArrayList<>();
        for (WebElement job : jobs) {
            click(job);
            departments.add(getText(department).split(" /")[0]);
            navigateBack();
        }
        return departments;
    }

    public void openFirstJob() {
        click(jobs.getFirst());
    }

    public void clickOnApplyForThisJobButton() {
        click(applyForThisJobButton);
    }

    public boolean isLeverApplicationPageOpened() {
        String currentUrl = getCurrentUrl();
        return currentUrl.contains("https://jobs.lever.co/") && currentUrl.contains("/apply");
    }

}
