package apis.post;

import models.post.PartialPost;
import models.post.Post;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.PostRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class NoAuthPostTests extends BaseTest {
    private final PostRequest postRequest = new PostRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @Test(groups = {regression})
    public void unAuthorizedSchemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/post/GetSinglePost.json";

        postRequest.getSinglePost(3);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedGetAllPostsTest() {
        postRequest.getAllPosts();

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedGetSinglePostTest() {
        postRequest.getSinglePost(3);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedDeletePostTest() {
        postRequest.deleteSinglePost(3);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedSortPostsTest() {
        final var queryParamMap = Map.of(
                "sorBy", "views",
                "order", "desc"
        );

        postRequest.sortPosts(queryParamMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedSearchPostsTest() {
        final var queryParamMap = Map.of(
                "q", "history"
        );

        postRequest.searchPosts(queryParamMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedCreatePostTest() {
        final var post = Post.generateRandomPost();

        postRequest.createPost(post);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedUpdatePostTest() {
        final var post = Post.generateRandomPost();

        postRequest.updatePost(3, post);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void unAuthorizedPartialUpdatePostTest() {
        final var partialPost = PartialPost.generateRandomPartialPost();

        postRequest.partialUpdatePost(3, partialPost);

        ResponseManager.verifyStatusCode(401);
    }
}
