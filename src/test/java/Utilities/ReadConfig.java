package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

    Properties properties; //Declare Properties class
    String path = "config.properties";

    // constructor
    public ReadConfig(){
        properties = new Properties();  //initialize Properties class
        try {
            FileInputStream fis  = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getBrowser(){
        String value = properties.getProperty("browser");
        if(value!=null)
        return value;
        else
            throw new RuntimeException("Browser value not given");
    }
}
