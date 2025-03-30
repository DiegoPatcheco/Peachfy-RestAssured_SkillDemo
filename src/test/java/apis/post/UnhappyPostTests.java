package apis.post;

import models.post.PartialPost;
import models.post.Post;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.PostRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyPostTests extends BaseTest {
    private final PostRequest postRequest = new PostRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void invalidGetSinglePostTest() {
        postRequest.getSinglePost(3000);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidDeletePostTest() {
        postRequest.deleteSinglePost(3000);

        ResponseManager.verifyStatusCode(404);

    }

    @Test(groups = {regression})
    public void invalidUpdatePostTest() {
        final var post = Post.generateRandomPost();

        postRequest.updatePost(3000, post);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidPartialUpdatePostTest() {
        final var partialPost = PartialPost.generateRandomPartialPost();

        postRequest.partialUpdatePost(3000, partialPost);

        ResponseManager.verifyStatusCode(404);
    }
}
