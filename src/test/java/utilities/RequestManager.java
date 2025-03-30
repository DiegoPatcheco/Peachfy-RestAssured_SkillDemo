package utilities;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import requests.AuthRequest;

public class RequestManager {
    public void initRequest() {
        Logs.debug("Creating request");
        final var request = RestAssured.given().spec(buildRequestSpec());

        Logs.debug("Setting request");
        new RequestProvider().set(request);
    }

    public RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .addFilter(new RequestFilter())
                .setBaseUri("https://dummyjson.com/auth")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Step("User authentication")
    public void initAuth() {
        final var authRequest = new AuthRequest();
        authRequest.login("src/test/resources/payloads/login.json");
        final var token = ResponseManager.getPathAsString("accessToken");

        new RequestProvider().get().auth().preemptive().oauth2(token);
    }
}
