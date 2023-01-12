package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.driver;

public class sauceDemoYourCartPage extends BrowserUtils {
    public sauceDemoYourCartPage(){
        PageFactory.initElements(driver.getDriver(), this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoYourCartPage.class);

    @FindBy(id="checkout")
    private WebElement checkout;

    public void setCheckout() { checkout.click();}
}
