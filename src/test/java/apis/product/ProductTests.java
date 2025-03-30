package apis.product;

import models.product.PartialProduct;
import models.product.Product;
import models.product.ProductResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.ProductRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

import java.util.Map;

public class ProductTests extends BaseTest {
    private final ProductRequest productRequest = new ProductRequest();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        requestManager.initAuth();
    }

    @Test(groups = {regression})
    public void schemaValidationTest() {
        final var schemaPath = "src/test/resources/schemas/product/GetSingleProduct.json";

        productRequest.getSingleProduct(2);

        ResponseManager.doSchemaValidation(schemaPath);
    }

    @Test(groups = {regression})
    public void getAllProductsTest() {
        productRequest.getAllProducts();

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void getSingleProductTest() {
        productRequest.getSingleProduct(2);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void deleteProductTest() {
        productRequest.deleteSingleProduct(2);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void sortProductsTest() {
        final var queryParamsMap = Map.of(
                "sortBy", "price",
                "order", "asc"
        );

        productRequest.sortProducts(queryParamsMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void searchProductsTest() {
        final var queryParamsMap = Map.of(
                "q", "kitchen"
        );

        productRequest.searchProducts(queryParamsMap);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void createProductTest() {
        final var product = Product.generateRandomProduct();

        productRequest.createProduct(product);

        ResponseManager.verifyStatusCode(201);
        ResponseManager.verifyResponseTime(1000);

        final var responseBody = ResponseManager.getResponseBody(ProductResponse.class);

        softAssert.assertTrue(responseBody.rating() <= 5);
        softAssert.assertTrue(responseBody.rating() >= 0);
        softAssert.assertTrue(responseBody.id() > 0);
        softAssert.assertAll();
    }

    @Test(groups = {regression})
    public void updateProductTest() {
        final var product = Product.generateRandomProduct();

        productRequest.updateProduct(2, product);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }

    @Test(groups = {regression})
    public void partialUpdateProductTest() {
        final var partialProduct = PartialProduct.generateRandomPartialProduct();

        productRequest.partialUpdateProduct(2, partialProduct);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }
}
