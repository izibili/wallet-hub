package review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Dashboard.dashboard;
import Dashboard.objects;

import static org.testng.Assert.fail;

public class reviewPage {

    public WebDriver driver;

    private StringBuffer verificationErrors = new StringBuffer();

    public static dashboard dashboard;
    public static objects object;

    @BeforeTest
    public void setUp() {
        //Selenium WebDriver needs this executable in order to in order to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();

        //Any activity you want to do concerning your automated test can now be done using the driver

        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application
        driver.get("https://wallethub.com/join/login");

    }

    //login here
    @Test(priority = 1)
    public void LoginTesting() throws InterruptedException {
        dashboard = new dashboard(driver);

        dashboard.LoginDetails("", "");
        dashboard.clickLogIn();
        //wait for 5 seconds to have enough time to load the user page
        Thread.sleep(5000);
        String clientPage = driver.getCurrentUrl();
        String page = "https://wallethub.com/profile/67340977i";
        Assert.assertEquals(clientPage, page);
        System.out.println("Successful Login");
        Thread.sleep(3000);

    }

    //go to the company page and rate them
    @Test(priority = 2)
    public void EnterPageAndSelect () throws InterruptedException{

        object = new objects(driver);

        //wait for 3 seconds
        Thread.sleep(3000);
        driver.get("http://wallethub.com/profile/test_insurance_company/");
        System.out.println("On company Page");

        //wait for 5 seconds
        Thread.sleep(5000);
        object.starChoice();
        System.out.println("4th Star selected");
    }

    //Enter your review and click on the submit button
    @Test(priority = 3)
    public void reviewProper () throws InterruptedException{
        object = new objects(driver);

        //wait to load page for 3 seconds
        Thread.sleep(3000);
        object.chooseReview();

        //inserting review text here
        object.writeAndSubmit("Aenean vulputate eleifend tellus. " +
                "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam " +
                "lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra " +
                "nulla ut metus varius laoreet.");
        //verify submission by printing out the text
        System.out.println("You have reviewed the Institution");
        //wait for 3 seconds to load the next page
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void checkProfile() throws InterruptedException {

        object = new objects(driver);

        object.homePage();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        String ActualUrl = "https://wallethub.com/profile/67340977i";
        Assert.assertEquals(url, ActualUrl);
        System.out.println("Project Complete!");

        }

    //close browser
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
