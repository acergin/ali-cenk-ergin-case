package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='header-menu-item']/*[@data-text]")
    private List<WebElement> headerItems;

    @FindBy(css = "header nav a")
    private List<WebElement> headerTopItems;

    @FindBy(xpath = "//div[@class='header-top-action']/a[.='Login']")
    private WebElement headerLoginButton;

    @FindBy(css = "div[class='header-top-action-lang']")
    private WebElement headerLanguageList;

    @FindBy(xpath = "//div[@class='header-menu-action']/a[not(contains(@class,'is-mobile'))]")
    private List<WebElement> headerActions ;

    @FindBy(css = "section")
    private List<WebElement> sections;

    @FindBy(id = "footer")
    private WebElement footer;

    @FindBy(xpath = "//div[@class='header-menu-action']/a[@href='/request-a-demo/' and not(contains(@class,'is-mobile'))]")
    private WebElement getDemoButton;

    @FindBy(css = "a.wt-cli-accept-all-btn")
    private WebElement cookiesAcceptAllBtn;

    @FindBy(css = "cookie-law-info-bar")
    private WebElement cookieBar;

    public void openHomePage() {
        navigateTo(ConfigReader.get("baseUrl"));
        acceptCookiesIfPresent();
    }

    public boolean isHomePageOpened() {
        return getCurrentUrl().contains("insiderone.com");
    }

    public List<String> getSections() {
        List<String> classNames = new ArrayList<>();
        for (WebElement section : sections) {
            scrollIntoView(section);
            classNames.add(getAttribute(section, "class").split(" ")[0]);
        }
        return classNames;
    }

    public List<String> getHeaderItems() {
        return headerItems.stream().map(WebElement::getText).toList();
    }

    public List<String> getHeaderTopItems() {
        return headerTopItems.stream().map(WebElement::getText).toList();
    }

    public List<String> getHeaderActions() {
        return headerActions.stream().map(WebElement::getText).toList();
    }

    public boolean isHeaderTopActionsDisplayed() {
        return isDisplayed(headerLoginButton) && isDisplayed(headerLanguageList);
    }

    public boolean isFooterDisplayed() {
        return isDisplayed(footer);
    }

    public void clickGetDemoButton() {
        click(getDemoButton);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(Driver.getDriver(),
                    Duration.ofSeconds(ConfigReader.getInt("shortTimeout")));
            WebElement acceptButton = shortWait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptAllBtn));
            acceptButton.click();
            shortWait.until(ExpectedConditions.invisibilityOf(cookieBar));
        } catch (Exception ignored) {}
    }
}