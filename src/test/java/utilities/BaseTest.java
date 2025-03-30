package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected RequestManager requestManager = new RequestManager();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssert = new SoftAssert();

        requestManager.initRequest();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.info("Teardown del padre");
    }
}
