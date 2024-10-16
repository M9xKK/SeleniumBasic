package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private final String browserName = "chrome";
    protected static WebDriver driver;
    private final String APP_URL = "http://www.automationpractice.pl/index.php";
    private Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected TestData testData;

    @BeforeEach
    void setup() throws IOException {
        driver = getDriver();
        driver.get(APP_URL);
        logger.info("URL defined properly");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Timeout set properly to 5 seconds");
        ObjectMapper objectMapper = new ObjectMapper();
        testData = objectMapper.readValue(new File("src/test/resources/configuration.json"), TestData.class);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        logger.info("Driver closed");
    }

    private WebDriver getDriver()
    {
        switch (this.browserName) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-search-engine-choice-screen");
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                logger.info("Chromer driver initialized properly");
            }
//            case "chromium" -> {
//                ChromiumOptions chromiumOptions = new ChromiumOptions();
//                WebDriverManager.chromiumdriver().setup();
//                chromiumOptions.addArguments("--start-maximized");
//                chromiumOptions.addArguments("--remote-allow-origins=*");
//                chromiumOptions.addArguments("--disable-search-engine-choice-screen");
//                chromiumOptions.addArguments("--headless");
//                driver = new ChromiumDriver(chromiumOptions);
//                logger.info("Chromer driver initialized properly");
//            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("--disable-search-engine-choice-screen");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                logger.info("Firefox driver initialized properly");

            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOptions.addArguments("start-maximized");
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-search-engine-choice-screen");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                logger.info("Edge driver initialized properly");

            }
            default -> {
                logger.info("Driver is not initialized");
                throw new UnsupportedOperationException("Unsupported browser selected");
            }
        }
        return driver;
    }
}
