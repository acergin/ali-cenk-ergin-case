package api.clients;

import api.models.Pet;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class PetClient {

    private final String baseUrl = ConfigReader.get("petStoreBaseUrl");

    public Response createPet(Pet pet) {
        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(pet)
                .when()
                .post("/pet");
    }

    public Response createPet(String rawBody) {
        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(rawBody)
                .when()
                .post("/pet");
    }

    public Response getPetById(long petId) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/pet/" + petId);
    }

    public Response getPetById(String petId) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/pet/" + petId);
    }

    public Response updatePet(Pet pet) {
        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(pet)
                .when()
                .put("/pet");
    }

    public Response deletePet(long petId) {
        return given()
                .baseUri(baseUrl)
                .when()
                .delete("/pet/" + petId);
    }
}