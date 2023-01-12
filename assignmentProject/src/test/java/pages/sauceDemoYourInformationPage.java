package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.driver;

public class sauceDemoYourInformationPage extends BrowserUtils {
    public sauceDemoYourInformationPage(){
        PageFactory.initElements(driver.getDriver(), this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoYourInformationPage.class);

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstNameInfo;
    @FindBy(xpath = "//*[@id='last-name']")
    private WebElement lastNameInfo;
    @FindBy(id = "postal-code")
    private WebElement zipPostalCodeInfo;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public void setFirstNameInfo(String firstnameinfo) {
        firstNameInfo.sendKeys(firstnameinfo);
    }

    public void setLastNameInfo(String lastnameinfo) {
        lastNameInfo.sendKeys(lastnameinfo);
    }

    public void setZipPostalCodeInfo(String zipostalcodeinfo) {
        zipPostalCodeInfo.sendKeys(zipostalcodeinfo);
    }

    public void setContinueButton() {
        continueButton.click();
    }
}
