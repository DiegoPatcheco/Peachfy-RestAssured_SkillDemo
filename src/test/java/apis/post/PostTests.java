package apis.post;

import models.post.PartialPost;
import models.post.Post;
import models.post.PostResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.PostRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class PostTests extends BaseTest {
    private final PostRequest postRequest = new PostRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void schemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/post/GetSinglePost.json";

        postRequest.getSinglePost(3);

        ResponseManager.doSchemaValidation(schemaPath);
    }

    @Test(groups = {regression})
    public void getAllPostsTest() {
        postRequest.getAllPosts();

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void getSinglePostTest() {
        postRequest.getSinglePost(3);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void deletePostTest() {
        postRequest.deleteSinglePost(3);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);

    }

    @Test(groups = {regression})
    public void sortPostsTest() {
        final var queryParamMap = Map.of(
                "sorBy", "views",
                "order", "desc"
        );

        postRequest.sortPosts(queryParamMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void searchPostsTest() {
        final var queryParamMap = Map.of(
                "q", "history"
        );

        postRequest.searchPosts(queryParamMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void createPostTest() {
        final var post = Post.generateRandomPost();

        postRequest.createPost(post);

        ResponseManager.verifyStatusCode(201);
        ResponseManager.verifyResponseTime(1000);

        final var responseBody = ResponseManager.getResponseBody(PostResponse.class);

        softAssert.assertTrue(responseBody.reactions().dislikes() >= 0);
        softAssert.assertTrue(responseBody.reactions().likes() >= 0);
        softAssert.assertTrue(responseBody.id() > 0);
        softAssert.assertAll();
    }

    @Test(groups = {regression})
    public void updatePostTest() {
        final var post = Post.generateRandomPost();

        postRequest.updatePost(3, post);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void partialUpdatePostTest() {
        final var partialPost = PartialPost.generateRandomPartialPost();

        postRequest.partialUpdatePost(3, partialPost);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }
}
