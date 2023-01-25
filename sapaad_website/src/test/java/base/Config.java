package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config {
    public static WebDriver driver;

    public static WebDriver setupDriver(String driverType){
        if (driverType.equalsIgnoreCase("ch")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (driverType.equalsIgnoreCase("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        return driver;
    }
}
