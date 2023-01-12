package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {

    // This is the driver that will be used throughout the framework
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>(); // It's a pool of drivers, so we can run parallel tests

    public driver(){}

    public static WebDriver getDriver(){
        if (driverPool.get() == null) { // It will assign one driver to each test scenario in order to run it parallel
            synchronized (driver.class){
                switch (ConfigurationsReader.getProperties("browser")){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    default:
                        System.out.println("Driver NOT found");
                }
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
