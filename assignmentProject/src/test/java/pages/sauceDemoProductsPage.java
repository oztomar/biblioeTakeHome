package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.driver;
import org.apache.log4j.Logger;


public class sauceDemoProductsPage extends BrowserUtils {
    public sauceDemoProductsPage(){
        PageFactory.initElements(driver.getDriver(), this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoProductsPage.class);

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement sauceLabsBikeLightAddToCartButton;
    @FindBy(xpath  = "//*[@id='shopping_cart_container']/a")
    private WebElement cart;

    public void setSauceLabsBikeLightAddToCartButton(){sauceLabsBikeLightAddToCartButton.click();}
    public void setCart(){cart.click();}

}
