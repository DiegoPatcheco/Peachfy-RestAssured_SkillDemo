package apis.product;

import models.product.PartialProduct;
import models.product.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.ProductRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyProductTests extends BaseTest {
    private final ProductRequest productRequest = new ProductRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void invalidGetSingleProductTest() {
        productRequest.getSingleProduct(2500);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidDeleteProductTest() {
        productRequest.deleteSingleProduct(2500);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidUpdateProductTest() {
        final var product = Product.generateRandomProduct();

        productRequest.updateProduct(2500, product);

        ResponseManager.verifyStatusCode(404);
    }

    @Test(groups = {regression})
    public void invalidPartialUpdateProductTest() {
        final var partialProduct = PartialProduct.generateRandomPartialProduct();

        productRequest.partialUpdateProduct(2500, partialProduct);

        ResponseManager.verifyStatusCode(404);
    }
}
