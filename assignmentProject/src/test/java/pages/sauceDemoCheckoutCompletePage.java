package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

public class sauceDemoCheckoutCompletePage {
    public sauceDemoCheckoutCompletePage(){
        PageFactory.initElements(driver.getDriver(),this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoCheckoutCompletePage.class);

    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    private WebElement orderHasBeenDispatchedText;

    public WebElement getOrderHasBeenDispatchedText(){
         return orderHasBeenDispatchedText;

    }



}
