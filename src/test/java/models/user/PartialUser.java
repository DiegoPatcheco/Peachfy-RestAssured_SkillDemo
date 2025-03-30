package models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public record PartialUser(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("age") int age
) {
    public static PartialUser generateRandomPartialUser() {
        final var faker = new Faker();

        final var firstName = faker.name().firstName();
        final var lastName = faker.name().lastName();
        final var age = faker.number().numberBetween(10, 80);

        return new PartialUser(firstName, lastName, age);
    }
}
