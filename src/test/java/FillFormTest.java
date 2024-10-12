import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FillFormTest {

    private static WebDriver driver;
    @Test
    void shouldFillFormWithPass()
    {
        driver = getDriver();
    }

    @Test
    void shouldFillFormWithFail()
    {
        System.out.println("Test fail");
    }

    private WebDriver getDriver()
    {
        String browserName = "chrome";
        switch(browserName){
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins");

            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();

            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();

            }
            default -> {
                throw new UnsupportedOperationException("Unsupported browser selected");
            }
        }
        return driver;
    }
}