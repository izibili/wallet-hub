package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.fail;


public class LoginTest {
    public WebDriver driver;

    private StringBuffer verificationErrors = new StringBuffer();

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;

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
        driver.get("https://www.facebook.com/");

    }


    //test login Ability
    @Test(priority = 1)
    public void testSuccessfulLogin() throws InterruptedException {

        loginPage = new LoginPage(driver);

        loginPage.insertEmail("");
        loginPage.insertPasswords("");
        loginPage.clickLogin();

        if (driver.getCurrentUrl().contains("https://web.facebook.com"))
            System.out.println("Successful Login");
        else
            System.out.println("not successful Login");
    }


    //test logout and check the current url if it is valid!
    @Test(priority = 1)
    public void testSuccessfulLogout() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);

        sleep(5000);
        //click profile button
        dashboardPage.LogOut();
        String expectedCurrentUrl = "https://www.facebook.com/";
        String actualCurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualCurrentUrl, expectedCurrentUrl);
        System.out.println("Hello World");
    }

    //close browser
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}