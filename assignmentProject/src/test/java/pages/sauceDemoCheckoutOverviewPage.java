package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

public class sauceDemoCheckoutOverviewPage {
    public sauceDemoCheckoutOverviewPage(){
        PageFactory.initElements(driver.getDriver(),this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoCheckoutOverviewPage.class);

    @FindBy(name = "finish")
    private WebElement finishButton;

    public void setFinishButton() {
        finishButton.click();
    }
}
