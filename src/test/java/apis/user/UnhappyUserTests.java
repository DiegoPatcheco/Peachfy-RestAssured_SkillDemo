package apis.user;

import models.user.PartialUser;
import models.user.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.UserRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyUserTests extends BaseTest {
    private final UserRequest userRequest = new UserRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void invalidGetSingleUserTest() {
        userRequest.getSingleUser(5000);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidDeleteUserTest() {
        userRequest.deleteSingleUser(5000);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidUpdateUserTest() {
        final var user = User.generateRandomUser();

        userRequest.updateUser(5000, user);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidPartialUpdateUserTest() {
        final var partialUser = PartialUser.generateRandomPartialUser();

        userRequest.partialUpdateUser(5000, partialUser);

        ResponseManager.verifyStatusCode(404);
    }
}
