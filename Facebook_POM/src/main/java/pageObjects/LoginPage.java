package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //In the page class
    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Using By as a locator for elements
    private By email   = By.id("email");
    private By password =By.id("pass");
    private By logInBtn = By.name("login");



    //functions to interact with the element
    public void insertEmail (String uid) throws InterruptedException
    {
        //wait for 1 seconds before typing the user email
        Thread.sleep(1000);
        driver.findElement(email).sendKeys(uid);
    }

    public void insertPasswords (String pwd) throws InterruptedException
    {
        //Wait for 2 seconds before typing the password
        Thread.sleep(2000);
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() throws InterruptedException
    {
        //Wait for 1 seconds before clicking the login button
        Thread.sleep(1000);
        driver.findElement(logInBtn).click();
    }
}