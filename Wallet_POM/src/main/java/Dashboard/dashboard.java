package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboard {
    public WebDriver driver;

    //call the driver
    public dashboard (WebDriver driver) {
        this.driver = driver;
    }
    //Using By as a locator for elements
    By name = By.id("email");
    By password = By.id("password");
    By login = By.xpath("(//button[@type='button'])[2]");

    //enter username and password
    public void LoginDetails (String EnterEmailHere, String EnterPasswordHere){
        driver.findElement(name).sendKeys(EnterEmailHere);
        driver.findElement(password).sendKeys(EnterPasswordHere);
    }
    //click on login button
    public void clickLogIn() throws InterruptedException{
        //wait for 2 seconds before clicking the login button
        Thread.sleep(2000);
        driver.findElement(login).click();
    }
}
