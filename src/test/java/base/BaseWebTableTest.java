package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BaseWebTableTest {
    private final String browserName = "chrome";
    protected static WebDriver driver;
    private final String APP_URL = "https://cosmocode.io/automation-practice-webtable/";
    private Logger logger = LoggerFactory.getLogger(BaseWebTableTest.class);

    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

    @BeforeEach
    void setup() {
        driver = getDriver();
        driver.get(APP_URL);
        logger.info("URL defined properly");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        logger.info("Timeout set properly to 5 seconds"); bedziemy korzystac z fluent waita
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

    protected void clickCheckbox(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Element "+element.getText() + " is clicked");
    }

    protected WebElement findCheckbox(List<WebElement> elementsList, int index)
    {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(index)));
        logger.info("Number of elements: "+elementsList.size() + " are registered");
        return checkbox;
    }
}
