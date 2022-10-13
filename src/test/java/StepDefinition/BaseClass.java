package StepDefinition;

import PageObject.LoginPage;
import Utilities.ReadConfig;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public LoginPage LoginPg;
    public static Logger log;

    public ReadConfig readConfig;

}
