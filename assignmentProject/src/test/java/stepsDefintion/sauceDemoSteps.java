package stepsDefintion;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.BrowserUtils;
import utilities.ConfigurationsReader;
import utilities.driver;
import org.apache.log4j.Logger;


public class sauceDemoSteps extends BrowserUtils {

    sauceDemoYourInformationPage sauceDemoYourInformationPage = new sauceDemoYourInformationPage();
    sauceDemoYourCartPage sauceDemoYourCartPage = new sauceDemoYourCartPage();
    sauceDemoProductsPage sauceDemoProductsPage = new sauceDemoProductsPage();
    sauceDemoLoginPage sauceDemoLoginPage = new sauceDemoLoginPage();
    sauceDemoCheckoutOverviewPage sauceDemoCheckoutOverviewPage= new sauceDemoCheckoutOverviewPage();
    sauceDemoCheckoutCompletePage sauceDemoCheckoutCompletePage = new sauceDemoCheckoutCompletePage();

    private static final Logger logger = Logger.getLogger(sauceDemoSteps.class);

    /* Deleted what was inside the blocks of code for each steps template because it only helps cucumber to throw
    exception when the steps don't have code*/

    @Given("The user wants to go to Sauce Demos website")
    public void the_user_wants_to_go_to_sauce_demos_website() {
        System.out.println("Testing Starting");
        setWaitTime();
        driver.getDriver().get(ConfigurationsReader.getProperties("sauceDemoURL"));
        driver.getDriver().manage().window().maximize();
    }
    @When("The user wants to login with valid credentials")
    public void the_user_wants_to_login_with_valid_credentials() {
        sauceDemoLoginPage.setUserName(ConfigurationsReader.getProperties("userName"));
        sauceDemoLoginPage.setPassWord(ConfigurationsReader.getProperties("password"));
        clickWithWait(sauceDemoLoginPage.getLoginButton());
        logger.info("Username and Password successfully provided");
    }
    @Then("The user wants to add Sauce Labs Bike Light to the Cart")
    public void the_user_wants_to_add_sauce_labs_bike_light_to_the_cart() {
    sauceDemoProductsPage.setSauceLabsBikeLightAddToCartButton();
    }
    @Then("The user wants to navigate to the Cart and click Checkout button")
    public void the_user_wants_to_navigate_to_the_cart_and_click_checkout_button() {
        sauceDemoProductsPage.setCart();
        sauceDemoYourCartPage.setCheckout();
    }
    @Then("The user wants to input Randomized valid First Name, Last Name and Zip_Postal Code")
    public void the_user_wants_to_input_randomized_valid_first_name_last_name_and_zip_postal_code() {
        Faker faker = new Faker();
        sauceDemoYourInformationPage.setFirstNameInfo(faker.name().firstName());
        sauceDemoYourInformationPage.setLastNameInfo(faker.name().lastName());
        sauceDemoYourInformationPage.setZipPostalCodeInfo(faker.address().zipCode());

    }
    @Then("The user wants to click Continue button, navigate to checkout: Overview then click Finish Button")
    public void the_user_wants_to_click_continue_button_navigate_to_checkout_overview_then_click_finish_button() {
    sauceDemoYourInformationPage.setContinueButton();
    sauceDemoCheckoutOverviewPage.setFinishButton();
    }
    @Then("The user wants to verify that item has successfully been ordered")
    public void the_user_wants_to_verify_that_item_has_successfully_been_ordered() {
        String actualText = sauceDemoCheckoutCompletePage.getOrderHasBeenDispatchedText().getText();
        Assert.assertEquals("CHECKOUT: COMPLETE!",actualText);
        Assert.assertTrue(sauceDemoCheckoutCompletePage.getOrderHasBeenDispatchedText().isDisplayed());

    }

}
