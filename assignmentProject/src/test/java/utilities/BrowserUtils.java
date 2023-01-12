package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BrowserUtils {
    // Created browser utilities to store useful methods to help with writing more understandable code
    public static void staticWait(int second){
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setWaitTime(){
        driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void clickWithWait(WebElement webElement){

        Wait wait = new FluentWait(driver.getDriver())
                .withTimeout(Duration.ofSeconds(15)) // Waits for 15 seconds
                .pollingEvery(Duration.ofMillis(800))// Polling > it will check for that elements for > 5
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);

        WebElement element = (WebElement) wait.until((Function<WebDriver,WebElement>) driver -> webElement);
        try {
            element.click();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
