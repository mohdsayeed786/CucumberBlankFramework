package StepDefinition;

import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class StepDef extends BaseClass {

    /////// Method need to executed before execution starts //////

    @Before
    public void setUp() {
        log = LogManager.getLogger("StepDef");
        log.info("***** Setup method executed ***** ");

        readConfig = new ReadConfig();
        String browser = readConfig.getBrowser();
        if ("chrome".equals(browser.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("msedge".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            driver = null;
        }
    }

    ///// Methods for Login Feature file page /////

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        LoginPg = new LoginPage(driver);
        log.info("***** User launch chrome browser method executed ***** ");

    }


    @When("User open URL {string}")
    public void user_open_url(String url) {
        driver.get(url);
        log.info("***** User open URL method executed ***** ");

    }


    @Then("Page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        log.info("***** Page title verification method executed ***** ");

    }


    @When("User click on LogOut Link")
    public void user_click_on_log_out_link() {
        LoginPg.ClickLogoutButton();
        log.info("***** User click on LogOut Link method executed ***** ");

    }


    @Then("Login Page Title should be {string}")
    public void login_page_title_should_be(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)) {
            Assert.assertTrue(true);
            log.warn("***** page title matched ***** ");
        } else {
            Assert.assertTrue(false);
            log.warn("***** page title not matched ***** ");
        }
        log.info("***** Login Page Title verification method executed ***** ");

    }


    @Then("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        LoginPg.EnterEmail(email);
        LoginPg.EnterPassword(password);
        log.info("***** User enter Email and Password method executed ***** ");

    }


    @Then("user click on Login Button")
    public void user_click_on_login_button() {
        LoginPg.ClickLoginButton();
        log.info("***** user click on Login Button method executed ***** ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /////// Method need to be executed after execution is over //////
    @After
    public void tearDown(Scenario sc) {
        System.out.println("************ Tear Down Method called ***********");

        if (sc.isFailed() == true) {

            String fileWithPath = ".//Screenshots/failedScreenShot.png";
            //Convert webDriver object to screenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            //Call getScreenShot method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            //Move srcFile image to designation file path
            File desFile = new File(fileWithPath);

            // Copy file at destination
            try {
                FileUtils.copyFile(srcFile, desFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        //driver.close();
        log.info("***** Failed Scenario Screenshot method executed ***** ");
    }

    //Extent Report
    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }


}
