package api.payloads;

import api.models.Category;
import api.models.Pet;
import api.models.Tag;

import java.util.List;

public final class PetPayloadBuilder {

    private PetPayloadBuilder() {
    }

    public static Pet validPet(long id, String name, String status) {
        return new Pet(
                id,
                new Category(1, "dogs"),
                name,
                List.of("https://example.com/dog.jpg"),
                List.of(new Tag(1, "friendly")),
                status
        );
    }

    public static String rawPayload(String id, String name, String status) {
        return """
                {
                  "id": %s,
                  "name": "%s",
                  "photoUrls": ["https://example.com/dog.jpg"],
                  "status": "%s"
                }
                """.formatted(id, name, status);
    }
}