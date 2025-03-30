package apis.user;

import models.user.PartialUser;
import models.user.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.UserRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class UserTests extends BaseTest {
    private final UserRequest userRequest = new UserRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void schemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/user/GetSingleUser.json";

        userRequest.getSingleUser(5);

        ResponseManager.doSchemaValidation(schemaPath);
    }

    @Test(groups = {regression})
    public void getAllUsersTest() {
        userRequest.getAllUsers();

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void getSingleUserTest() {
        userRequest.getSingleUser(5);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void deleteUserTest() {
        userRequest.deleteSingleUser(5);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void sortUsersTest() {
        final var paramsMap = Map.of(
                "sortBy", "age",
                "order", "desc"
        );

        userRequest.sortUsers(paramsMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void filterUsersTest() {
        final var paramsMap = Map.of(
                "key", "address.city",
                "value", "Phoenix"
        );

        userRequest.filterUsers(paramsMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void createUserTest() {
        final var user = User.generateRandomUser();

        userRequest.createUser(user);

        ResponseManager.verifyStatusCode(201);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void updateUserTest() {
        final var user = User.generateRandomUser();

        userRequest.updateUser(5, user);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void partialUpdateUserTest() {
        final var partialUser = PartialUser.generateRandomPartialUser();

        userRequest.partialUpdateUser(5, partialUser);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }
}
