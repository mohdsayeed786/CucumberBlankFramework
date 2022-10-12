package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;  //creating object of WebDriver

    public LoginPage(WebDriver rDriver)  //creating parametrized constructor
    {
     ldriver = rDriver;  //in local WebDriver object assign remote WebDriver object
        PageFactory.initElements(rDriver, this);  // for initialization
    }

    @FindBy(id = "Email")
    WebElement Email;

    public void EnterEmail(String EmailAddress){
        Email.clear();
        Email.sendKeys(EmailAddress);
    }

    @FindBy(id = "Password")
    WebElement Password;

    public void EnterPassword(String PasswordAddress){
        Password.clear();
        Password.sendKeys(PasswordAddress);
    }

    @FindBy(css = "button[type='submit']")
    WebElement LoginButton;

    public void ClickLoginButton(){
        LoginButton.click();
    }

    @FindBy(linkText = "Logout")
    WebElement LogoutButton;

    public void ClickLogoutButton(){
        LogoutButton.click();
    }
}
