package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public final class Driver {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigReader.get("browser");

            if ("chrome".equalsIgnoreCase(browser)) {
                ChromeOptions options = new ChromeOptions();

                if (ConfigReader.getBoolean("headless")) {
                    options.addArguments("--headless=new");
                }

                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");

                WebDriver driver = new ChromeDriver(options);
                int timeout = Integer.parseInt(ConfigReader.get("timeout"));
                driver.manage().timeouts().implicitlyWait(Duration.ZERO);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));

                driverPool.set(driver);
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        WebDriver driver = driverPool.get();

        if (driver != null) {
            driver.quit();
            driverPool.remove();
        }
    }
}