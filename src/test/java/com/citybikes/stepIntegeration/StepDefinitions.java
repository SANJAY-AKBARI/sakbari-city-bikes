package com.citybikes.stepIntegeration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;



import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {
    private String baseUri;
    Response response;
    RequestSpecification request;
    int responseCode;
    ResponseBody<?> respBody;

    @Given("I want to get the city bikes location")
    public void iWantToGetTheCityBikesLocation() {
        baseUri="http://api.citybik.es/v2";
        request = RestAssured.given().log().all().config(RestAssuredConfig.config().encoderConfig(
                 RestAssured.config().getEncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }


    @When("I send request with {string}")
    public void iSendRequestWith(String absUrl) {
        response = request.baseUri(baseUri).when().request(Method.GET,absUrl).
                then().log().all().extract().response();
        respBody = response.getBody();
    }

    @Then("I get the successful response {int}")
    public void iGetTheSuccessfulResponse(int respCode) {
        responseCode = response.getStatusCode();
        assertThat(responseCode, CoreMatchers.is(respCode));
    }

    @Then("I am looking for the {string}")
    public void iAmLookingForThe(String cityName) {
        respBody = response.getBody();
        String country = respBody.jsonPath().getString("network.location.country");
        String latitude = respBody.jsonPath().getString("network.location.latitude");
        String longitude = respBody.jsonPath().getString("network.location.longitude");
        assertThat(country, is(equalTo("DE")));
        System.out.println("Latitude of " +cityName+ ":"+latitude);
        System.out.println("Longitude of " +cityName+ ":"+longitude);
    }

    @When("I send request with {string} with queryParam {string} as {string}")
    public void iSendRequestWithWithQueryParamAs(String absUrl, String queryParamField, String queryParams) {
        response = request.baseUri(baseUri).queryParam(queryParamField,queryParams)
                .when().request(Method.GET,absUrl).
                then().log().all().extract().response();
    }
}
