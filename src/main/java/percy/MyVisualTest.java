package percy;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.percy.selenium.Percy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class MyVisualTest
{
    private static RemoteWebDriver driver;
    private static Percy percy;

    @Test
    public void gtjTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        percy = new Percy(driver);
        driver.get("https://www.calculator.net/random-number-generator.html?slower=1&supper=100&ctype=1&s=169&submit1=Generate");
        percy.snapshot("Random Number Example");
        driver.close();

    }
}
