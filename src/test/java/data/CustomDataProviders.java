package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {
    public static final String ERROR_CREDENTIALS_DP = "errorCredentialsDP";

    @DataProvider(name = ERROR_CREDENTIALS_DP)
    public Object[][] errorCredentialsDP() {
        final var templatePath = "src/test/resources/payloads/%s.json";

        return new Object[][]{
                {String.format(templatePath, "invalidCredentials"), 400},
                {String.format(templatePath, "emptyCredentials"), 400}
        };
    }
}
