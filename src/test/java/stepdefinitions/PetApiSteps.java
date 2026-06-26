package stepdefinitions;

import api.clients.PetClient;
import api.payloads.PetPayloadBuilder;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PetApiSteps {

    private final PetClient petClient = new PetClient();

    private Response response;

    private long petId;
    private String petName;
    private String petStatus;

    @Given("User has created a pet")
    public void userHasCreatedAPet() {
        petId = Math.abs(UUID.randomUUID().getMostSignificantBits());
        petName = "QA Dog";
        petStatus = "available";
        response = petClient.createPet(PetPayloadBuilder.validPet(petId, petName, petStatus));
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @When("User creates a pet with valid data")
    public void userCreatesPetWithValidData() {
        petId = Math.abs(UUID.randomUUID().getMostSignificantBits());
        petName = "QA Dog";
        petStatus = "available";
        response = petClient.createPet(PetPayloadBuilder.validPet(petId, petName, petStatus));
    }

    @When("User gets the pet by id")
    public void userGetsThePetById() {
        response = petClient.getPetById(petId);
    }

    @When("User updates the pet name and status")
    public void userUpdatesThePetNameAndStatus() {
        petName = "Updated QA Dog";
        petStatus = "sold";
        response = petClient.updatePet(PetPayloadBuilder.validPet(petId, petName, petStatus));
    }

    @When("User deletes the pet by id")
    public void userDeletesThePetById() {
        response = petClient.deletePet(petId);
    }

    @When("User gets pet with id {string}")
    public void userGetsPetWithId(String petId) {
        response = petClient.getPetById(petId);
    }

    @When("User creates a pet with raw id {string}, name {string} and status {string}")
    public void userCreatesPetWithRawIdNameAndStatus(String id, String name, String status) {
        response = petClient.createPet(PetPayloadBuilder.rawPayload(id, name, status));
    }

    @Then("Pet API response status code should be {int}")
    public void petApiResponseStatusCodeShouldBe(int statusCode) {
        assertThat(response.statusCode()).as(response.asPrettyString()).isEqualTo(statusCode);
    }

    @Then("Created pet response should contain correct pet data")
    public void createdPetResponseShouldContainCorrectPetData() {
        assertThat(response.jsonPath().getLong("id")).isEqualTo(petId);
        assertThat(response.jsonPath().getString("name")).isEqualTo(petName);
        assertThat(response.jsonPath().getString("status")).isEqualTo(petStatus);
    }

    @Then("Pet response should contain correct pet id")
    public void petResponseShouldContainCorrectPetId() {
        assertThat(response.jsonPath().getLong("id")).isEqualTo(petId);
    }

    @Then("Pet response should contain updated pet data")
    public void petResponseShouldContainUpdatedPetData() {
        assertThat(response.jsonPath().getLong("id")).isEqualTo(petId);
        assertThat(response.jsonPath().getString("name")).isEqualTo(petName);
        assertThat(response.jsonPath().getString("status")).isEqualTo(petStatus);
    }

    @Then("Deleted pet should not be found")
    public void deletedPetShouldNotBeFound() {
        Response deletedPetResponse = petClient.getPetById(petId);
        assertThat(deletedPetResponse.statusCode()).isEqualTo(404);
    }
}