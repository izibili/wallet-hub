package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class objects
{
    public WebDriver driver;

    //call the driver and set the locators
    public objects(WebDriver driver) {
        this.driver = driver;
    }
    By star1 = By.cssSelector("div.rv.review-action.ng-enter-element > review-star.rvs-svg > div.rating-box-wrapper > svg.rvs-star-svg > g > path");
    By star2 = By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(2)");
    By star3 = By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(3)");
    By star4 = By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(4)");
    By section = By.xpath("//section[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/span");
    By drop = By.xpath("//section[@id='reviews-section']/modal-dialog/div/div/write-review/div/ng-dropdown/div/ul/li[2]");
    By text = By.cssSelector(".wrev-user-input");
    By submit = By.cssSelector(".sbn-action");
    By profile = By.xpath("//div[5]/span");
    By id = By.xpath("//a[contains(text(),'Profile')]");

    public void starChoice() throws InterruptedException {

        //move through the list of stars till it gets to the fourth star
        WebElement Star1 = driver.findElement(star1);
        WebElement Star2 = driver.findElement(star2);
        WebElement Star3 = driver.findElement(star3);

        Actions act = new Actions(driver);
        act.moveToElement(Star1).perform();
        Thread.sleep(2000);
        act.moveToElement(Star2).perform();
        Thread.sleep(2000);
        act.moveToElement(Star3).perform();
        Thread.sleep(2000);

        //click on the fourth star
        driver.findElement(star4).click();
    }
    public void chooseReview () throws InterruptedException{
        //wait for 2 seconds and click on dropdown and select from the list of alternatives
        Thread.sleep(2000);
        driver.findElement(section).click();
        driver.findElement(drop).click();
    }

    public void writeAndSubmit(String writeYourtextHere) throws InterruptedException{
        //insert the review text here
        driver.findElement(text).sendKeys(writeYourtextHere);

        //wait for 4 seconds to see the text
        Thread.sleep(4000);
        //click on the submit button
        driver.findElement(submit).click();
    }

    public void homePage() throws InterruptedException{
        WebElement user = driver.findElement(profile);
        Actions list = new Actions(driver);
        list.moveToElement(user).perform();
        //wait for 2 seconds
        Thread.sleep(2000);
        List<WebElement> links = driver.findElements(id);
        int total_count = links.size();
        for (int i = 0; i < total_count; i++) {
            WebElement element = links.get(i);
            String text = element.getText();
            if (text.equalsIgnoreCase("Profile")) {
                element.click();
                break;
            }
        }

    }
}
