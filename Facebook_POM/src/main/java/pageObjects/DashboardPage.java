package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class DashboardPage {
    //create a webDriver object for this class
    public WebDriver driver;

    //create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locate elements
    private By avatar = By.cssSelector(".fop5sh7t image");
    private By homePage = By.cssSelector(".buofh1pr:nth-child(1) > .tojvnm2t .a8c37x1j");
    private By LogOut = By.cssSelector(".j83agx80:nth-child(1) > .oajrlxb2:nth-child(1) > .hu5pjgll");
    private By logOutBtn = By.cssSelector("div:nth-child(5) > .oajrlxb2 > .ow4ym5g4 .d2edcug0");



    //Activities of the driver for the locators
    public void LogOut() throws InterruptedException {
        //Check user profile and wait for two seconds
        driver.findElement(avatar).click();
        sleep(2000);

        //Go back to the home page before the logout element and click on the logout button
        driver.findElement(homePage).click();
        sleep(2000);

            WebElement ChName = driver.findElement(LogOut);
            Actions act = new Actions(driver);
            act.moveToElement(ChName).perform();
            List<WebElement> links = driver.findElements(logOutBtn);
            int total_count = links.size();
            for (int i = 0; i < total_count; i++) {
                WebElement element = links.get(i);
                String text = element.getText();
                if (text.equalsIgnoreCase("logout")) {
                    element.click();
                    break;
                }
            }

        }

    }
