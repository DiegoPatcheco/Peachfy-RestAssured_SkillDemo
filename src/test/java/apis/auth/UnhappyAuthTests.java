package apis.auth;

import data.CustomDataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyAuthTests extends BaseTest {
    private final AuthRequest authRequest = new AuthRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @Test(
            groups = {regression},
            dataProviderClass = CustomDataProviders.class,
            dataProvider = CustomDataProviders.ERROR_CREDENTIALS_DP)
    public void errorCredentialsLoginTest(String path, int statusCode) {
        authRequest.login(path);
        ResponseManager.verifyStatusCode(statusCode);
    }
}
