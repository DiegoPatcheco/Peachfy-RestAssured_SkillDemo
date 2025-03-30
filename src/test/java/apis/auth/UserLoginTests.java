package apis.auth;

import models.login.LoginResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UserLoginTests extends BaseTest {
    private final AuthRequest authRequest = new AuthRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @Test(groups = {regression})
    public void userLoginTest() {
        final var bodyFilePath = "src/test/resources/payloads/login.json";

        authRequest.login(bodyFilePath);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);

        final var responseBody = ResponseManager.getResponseBody(LoginResponse.class);

        softAssert.assertEquals(responseBody.refreshToken().length(), 360);
        softAssert.assertEquals(responseBody.accessToken().length(), 360);
        softAssert.assertTrue(responseBody.id() > 0);
        softAssert.assertAll();
    }
}
