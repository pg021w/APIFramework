package stepDefinitions;

import Utils.APIResources;
import Utils.TestDataBuild;
import Utils.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class AddPlaceStepDef extends utils {


    TestDataBuild testDataBuild = new TestDataBuild();


    @Given("^When user hits API with (.+),(.+),(.+) data$")
    public void when_user_hits_api_with_name_address_data(String name, String address,String phone_num) throws IOException {
//        RestAssured.baseURI = "https://rahulshettyacademy.com";
//        req=given().spec(requestSpecification()).body(testDataBuild.getTestDataForAddPlace(name,address,phone_num));
       String jsonContent= FileUtils.readFileToString(new File("src/test/resources/Payload.json"), StandardCharsets.UTF_8);
        req=given().spec(requestSpecification()).body(jsonContent);


    }
    @When("user hits {string} for {string}")
    public void user_hits_post(String call,String api) {
        // Write code here that turns the phrase above into concrete actions
        APIResources resource= APIResources.valueOf(api);
        if(call.equalsIgnoreCase("POST"))
        {
            res=req.when().post(resource.getResource());
        }
        else if(call.equalsIgnoreCase("GET"))
        {
            res=req.when().get(resource.getResource());
        }


    }
    @Then("Validate user is getting status code as {int}")
    public void validate_user_is_getting_status_code_as(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        res.then().log().all().assertThat().statusCode(int1);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(getJsonValue(key, res), value);
    }

    @Then("store {string} to use for Get Place API")
    public void store_in(String key) {
        // Write code here that turns the phrase above into concrete actions
        place_id=getJsonValue(key, res);
    }

    @Then("store {string} in {string} to use for Get Place API")
    public String store_in_variable(String key, String placeHolder) {
        // Write code here that turns the phrase above into concrete actions
        placeHolder=getJsonValue(key, res);
        return placeHolder;
    }

}
