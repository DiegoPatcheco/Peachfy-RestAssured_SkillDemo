package apis.user;

import models.user.PartialUser;
import models.user.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.UserRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class NoAuthUserTests extends BaseTest {
    private final UserRequest userRequest = new UserRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @Test(groups = {regression})
    public void noAuthorizationSchemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/user/GetSingleUser.json";

        userRequest.getSingleUser(5);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationGetAllUsersTest() {
        userRequest.getAllUsers();

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationGetSingleUserTest() {
        userRequest.getSingleUser(5);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationDeleteUserTest() {
        userRequest.deleteSingleUser(5);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationSortUsersTest() {
        final var paramsMap = Map.of(
                "sortBy", "age",
                "order", "desc"
        );

        userRequest.sortUsers(paramsMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationFilterUsersTest() {
        final var paramsMap = Map.of(
                "key", "address.city",
                "value", "Phoenix"
        );

        userRequest.filterUsers(paramsMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationCreateUserTest() {
        final var user = User.generateRandomUser();

        userRequest.createUser(user);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationUpdateUserTest() {
        final var user = User.generateRandomUser();

        userRequest.updateUser(5, user);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationPartialUpdateUserTest() {
        final var partialUser = PartialUser.generateRandomPartialUser();

        userRequest.partialUpdateUser(5, partialUser);

        ResponseManager.verifyStatusCode(401);
    }
}
