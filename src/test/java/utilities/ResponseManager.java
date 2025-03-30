package utilities;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

public class ResponseManager {
    private static Response response;

    @Step("Verify status code")
    public static void verifyStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Step("Verify response time")
    public static void verifyResponseTime(int expectedResponseTime) {
        Assert.assertTrue(response.getTime() < expectedResponseTime);
    }

    @Step("Verify schema validation")
    public static void doSchemaValidation(String schemaFilePath) {
        response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));
    }

    public static <T> T getResponseBody(Class<T> clazz) {
        return response.body().as(clazz);
    }

    public static String getPathAsString(String path) {
        return response.path(path).toString();
    }

    public static void setResponse(Response response) {
        ResponseManager.response = response;
    }
}
