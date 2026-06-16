package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
      
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static WebDriver get() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}
