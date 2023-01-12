package stepsDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiSteps {
    Response response;
    @Given("User requests Toronto weather")
    public void user_requests_toronto_weather() {
        response = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?lat=43.6534817&lon=-79.3839347&appid=63bfdbd8ac6c5815820eb0a068e3b499");
    }
    @Then("Print response body and status code")
    public void print_response_body_and_status_code() {
        System.out.println("Response :"+ response.asString());
        System.out.println("Status Code:"+ response.getStatusCode());
    }
}
