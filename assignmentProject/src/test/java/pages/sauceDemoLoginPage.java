package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.driver;
import org.apache.log4j.Logger;



public class sauceDemoLoginPage extends BrowserUtils {
    public sauceDemoLoginPage(){
        PageFactory.initElements(driver.getDriver(),this);
    }
    private static final Logger logger = Logger.getLogger(sauceDemoLoginPage.class);

    @FindBy(id="user-name")
    private WebElement userName;
    @FindBy(id="password")
    private WebElement passWord;
    @FindBy(xpath = "//input[@name='login-button']")
    private WebElement loginButton;

    public void setUserName(String username) {
        if (!username.isEmpty()){
            logger.error("Username is empty. Please check the value you provided");
            logger.info("Please check if you provided username correctly");
        }
        staticWait(1);
        userName.sendKeys(username);
    }
    public void setPassWord(String password) {
        if (!password.isEmpty()){
            logger.error("Password is empty. Please check the value you provided");
            logger.info("Please check if you provided password correctly");
        }
        passWord.sendKeys(password);
    }
    public WebElement getLoginButton() {
        return loginButton;
    }

}
