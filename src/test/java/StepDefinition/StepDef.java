package StepDefinition;

import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class StepDef extends BaseClass {


    ///// Methods for Login Feature file page /////

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LoginPg = new LoginPage(driver);

    }


    @When("User open URL {string}")
    public void user_open_url(String url) {
        driver.get(url);

    }


    @Then("Page title should be {string}")
    public void page_title_should_be(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


    @When("User click on LogOut Link")
    public void user_click_on_log_out_link() {
        LoginPg.ClickLogoutButton();

    }


    @Then("Login Page Title should be {string}")
    public void login_page_title_should_be(String ExpectedTitle) {
        String ActualTitle = driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


    @Then("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        LoginPg.EnterEmail(email);
        LoginPg.EnterPassword(password);

    }


    @Then("user click on Login Button")
    public void user_click_on_login_button() {
        LoginPg.ClickLoginButton();

    }

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
    }


}
