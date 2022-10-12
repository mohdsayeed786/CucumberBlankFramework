package StepDefinition;

import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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


}
