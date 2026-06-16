package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import utils.DriverFactory;
import pages.AccountPage;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Steps {

    private AccountPage page;
    private String username = "user" + System.currentTimeMillis();
    private String password = "pass123";

    @Given("open site")
    public void openSite() {
        DriverFactory.init();
        DriverFactory.get().get("https://parabank.parasoft.com/parabank/index.htm");
        page = new AccountPage(DriverFactory.get(), DriverFactory.getWait());
    }

    @When("register")
    public void register() {
        page.openReg();
        page.reg(username, password);
        page.navigateToAccountOverview();
    }

    @And("pre register user")
    public void preRegisterUser() {
        page.openReg();
        page.reg(username, password);
        DriverFactory.get().get("https://parabank.parasoft.com/parabank/logout.htm");
    }

    @When("login with registered credentials")
    public void loginWithRegisteredCredentials() {
        page.login(username, password);
    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        Assert.assertTrue(page.isLoggedIn(), "Expected account overview table after login");
    }

    @Then("balance shown")
    public void balanceShown() {
        String bal = page.bal();
        Assert.assertNotNull(bal, "Balance should not be null");
        Assert.assertTrue(bal.contains("$"), "Balance should contain '$', got: " + bal);
        System.out.println("Account balance: " + bal);
    }


    @After
    public void tearDown() {
        DriverFactory.quit();
    }
    
    @AfterStep
    public void captureScreenshotOnFailure(Scenario scenario) {

        if (DriverFactory.get() != null) {

            byte[] screenshot = ((TakesScreenshot) DriverFactory.get())

                .getScreenshotAs(OutputType.BYTES);

            if (scenario.isFailed()) {

                scenario.attach(screenshot, "image/png",

                    "Screenshot on Failure - " + scenario.getName());

            } else {

                scenario.attach(screenshot, "image/png",

                    "Screenshot - " + scenario.getName());

            }

        }

    }
}
