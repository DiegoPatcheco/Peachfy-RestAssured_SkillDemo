package apis.product;

import models.product.PartialProduct;
import models.product.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.ProductRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class NoAuthProductTests extends BaseTest {
    private final ProductRequest productRequest = new ProductRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
    }

    @Test(groups = {regression})
    public void noAuthorizationSchemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/product/GetSingleProduct.json";

        productRequest.getSingleProduct(2);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationGetAllProductsTest() {
        productRequest.getAllProducts();

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationGetSingleProductTest() {
        productRequest.getSingleProduct(2);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationDeleteProductTest() {
        productRequest.deleteSingleProduct(2);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationSortProductsTest() {
        final var queryParamsMap = Map.of(
                "sortBy", "price",
                "order", "asc"
        );

        productRequest.sortProducts(queryParamsMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationSearchProductsTest() {
        final var queryParamsMap = Map.of(
                "q", "kitchen"
        );

        productRequest.searchProducts(queryParamsMap);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationCreateProductTest() {
        final var product = Product.generateRandomProduct();

        productRequest.createProduct(product);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationUpdateProductTest() {
        final var product = Product.generateRandomProduct();

        productRequest.updateProduct(2, product);

        ResponseManager.verifyStatusCode(401);
    }

    @Test(groups = {regression})
    public void noAuthorizationPartialUpdateProductTest() {
        final var partialProduct = PartialProduct.generateRandomPartialProduct();

        productRequest.partialUpdateProduct(2, partialProduct);

        ResponseManager.verifyStatusCode(401);
    }
}
