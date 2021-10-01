package applitools;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ApplitoolTest
{
    public WebDriver driver;
    public Eyes eyes;
    public EyesRunner runner;
    public static BatchInfo batch;

    @BeforeClass
    public void beforeSetup()
    {
        batch = new BatchInfo("GTJ batch");
    }

    @BeforeMethod
    public void setup()
    {

        // Initialize the Runner for your test.
        runner = new ClassicRunner();

        // Initialize the eyes SDK
        eyes = new Eyes(runner);

        // Set your personal Applitols API Key from your environment variables.
        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));

        // set batch name
        eyes.setBatch(batch);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void gtjTest()
    {
        eyes.open(driver,"GTJ App","GTJ Test1");
        driver.get("https://www.amazon.in/s?k=harry+potter&i=stripbooks&ref=nb_sb_noss_2");
        eyes.checkWindow();
        eyes.close();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
        eyes.abortIfNotClosed();

        // Wait and collect all test results
        TestResultsSummary allTestResults = runner.getAllTestResults();

        // Print results
        System.out.println(allTestResults);
    }
}
