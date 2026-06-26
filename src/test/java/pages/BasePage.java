package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {

    private final WebDriverWait wait;

    protected BasePage() {
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(ConfigReader.getInt("timeout")));
    }

    protected void navigateTo(String url) {
        Driver.getDriver().get(url);
        waitForPageLoad();
    }

    protected void waitForPageLoad() {
        wait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    protected WebElement waitVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected String getCurrentUrl() {
        return Objects.requireNonNull(Driver.getDriver().getCurrentUrl());
    }

    protected WebElement waitClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitClickable(element).click();
    }

    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return waitVisible(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected String getAttribute(WebElement element, String attribute) {
        waitVisible(element);
        return element.getAttribute(attribute);
    }

    protected String getText(WebElement element) {
        waitVisible(element);
        return element.getText();
    }

    protected void navigateBack() {
        Driver.getDriver().navigate().back();
    }

    protected void waitForUrlContains(String urlPart) {
        wait.until(ExpectedConditions.urlContains(urlPart));
    }

    protected void waitForTitleContains(String titlePart) {
        wait.until(ExpectedConditions.titleContains(titlePart));
    }

    protected String getPageTitle() {
        waitForPageLoad();
        return Driver.getDriver().getTitle();
    }

    protected void waitUntilOpenJobCountChange(WebElement element) {
        WebDriverWait longWait = new WebDriverWait(Driver.getDriver(),
                Duration.ofSeconds(ConfigReader.getInt("jobCountTimeout")));
        longWait.until(driver -> !element.getText().trim().contains("0 Open Positions"));
    }

}