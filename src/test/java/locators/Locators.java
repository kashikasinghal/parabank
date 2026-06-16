package locators;

import org.openqa.selenium.By;

public class Locators {
    // Navigation
    public static By registerLink = By.linkText("Register");

    // Registration form fields (all required by ParaBank)
    public static By firstName        = By.id("customer.firstName");
    public static By lastName         = By.id("customer.lastName");
    public static By address          = By.id("customer.address.street");
    public static By city             = By.id("customer.address.city");
    public static By state            = By.id("customer.address.state");
    public static By zipCode          = By.id("customer.address.zipCode");
    public static By phone            = By.id("customer.phoneNumber");
    public static By ssn              = By.id("customer.ssn");
    public static By username         = By.id("customer.username");
    public static By password         = By.id("customer.password");
    public static By confirmPassword  = By.id("repeatedPassword");
    public static By registerBtn      = By.xpath("//input[@value='Register']");

    // Post-registration confirmation
    public static By welcomeMessage   = By.xpath("//p[contains(text(),'Your account was created successfully')]");

    // Login form
    public static By loginUser = By.name("username");
    public static By loginPass = By.name("password");
    public static By loginBtn  = By.xpath("//input[@value='Log In']");

    // Post-login: account overview table
    public static By accountTable = By.id("accountTable");

    // Balance — scoped to the account table to avoid false matches
    //public static By balance = By.xpath("//table[@id='accountTable']//td[contains(text(),'$')]");
    public static By balance = By.xpath("//table[@id='accountTable']//.//td[contains(text(),'$')]");
}
