package stepDefinitions;

import Utils.utils;
import io.cucumber.java.en.Given;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetPlaceStepDef extends utils {

    @Given("When user hits API with placeId of Add Place API")
    public void when_user_hits_api_with_place_id_of_add_place_api() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Place id is "+place_id);
        req= given().spec(requestSpecification()).queryParam("place_id",place_id);

    }

    @Given("^When user hits API with (.+) of Add Place API$")
    public void when_user_hits_api_with_place_id_(String place_id) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Place id is "+place_id);
        req= given().spec(requestSpecification()).queryParam("place_id",place_id);

    }
}
