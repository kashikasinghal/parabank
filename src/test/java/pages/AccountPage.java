package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;

public class AccountPage {
    private WebDriver d;
    private WebDriverWait wait;

    public AccountPage(WebDriver d, WebDriverWait wait) {
        this.d = d;
        this.wait = wait;
    }

    // Opens the Register page
    public void openReg() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.registerLink)).click();
    }

    // Fills and submits the registration form
    // NOTE: After successful registration, ParaBank auto-logs in the user.
    // Do NOT call login() immediately after reg() — user is already logged in.
    public void reg(String u, String p) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstName))
            .sendKeys("Test");
        d.findElement(Locators.lastName).sendKeys("User");
        d.findElement(Locators.address).sendKeys("123 Main St");
        d.findElement(Locators.city).sendKeys("Boston");
        d.findElement(Locators.state).sendKeys("MA");
        d.findElement(Locators.zipCode).sendKeys("02101");
        d.findElement(Locators.phone).sendKeys("5551234567");
        d.findElement(Locators.ssn).sendKeys("123456789");
        d.findElement(Locators.username).sendKeys(u);
        d.findElement(Locators.password).sendKeys(p);
        d.findElement(Locators.confirmPassword).sendKeys(p);
        d.findElement(Locators.registerBtn).click();
        // Wait for confirmation page
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.welcomeMessage));
    }

    // Logs out first, then logs in — safe to call after reg()
    public void login(String u, String p) {
        // Navigate to home to ensure we're at the login form
        d.get("https://parabank.parasoft.com/parabank/index.htm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginUser))
            .sendKeys(u);
        d.findElement(Locators.loginPass).sendKeys(p);
        d.findElement(Locators.loginBtn).click();
        // Wait until the account overview page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountTable));
    }

    public boolean isLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountTable));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String bal() {
        WebElement balanceCell = wait.until(
            ExpectedConditions.visibilityOfElementLocated(Locators.balance)
        );
        return balanceCell.getText();
    }
    
    public void navigateToAccountOverview() {
        d.get("https://parabank.parasoft.com/parabank/overview.htm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.accountTable));
    }
}
