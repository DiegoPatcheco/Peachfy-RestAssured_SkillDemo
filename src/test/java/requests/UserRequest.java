package requests;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import models.user.PartialUser;
import models.user.User;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class UserRequest extends BaseRequest {
    @Step("(GET) Get all users Request")
    public void getAllUsers() {
        Logs.info("(GET) Get all users Request");

        final var response = getRequest()
                .basePath("users")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) Get single user Request")
    public void getSingleUser(int id) {
        Logs.info("(GET) Get single user Request");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(DELETE) Delete single user Request")
    public void deleteSingleUser(int id) {
        Logs.info("(Delete) Delete single user Request");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) Sort users Request")
    public void sortUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Sort users Request");

        final var response = getRequest()
                .basePath("users")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) Filter users Request")
    public void filterUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Filter users Request");

        final var response = getRequest()
                .basePath("users/filter")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(POST) Create post Request")
    public void createUser(User user) {
        Logs.info("(POST) Create user Request");

        final var response = getRequest()
                .basePath("users/add")
                .header("Content-Type", "application/json")
                .body(user)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    @Step("(PUT) Update post Request")
    public void updateUser(int id, User user) {
        Logs.info("(PUT) Update user Request");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .body(user)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    @Step("(PATCH) Partial update post Request")
    public void partialUpdateUser(int id, PartialUser partialUser) {
        Logs.info("(PATCH) Partial update user Request");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .body(partialUser)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);
    }
}
