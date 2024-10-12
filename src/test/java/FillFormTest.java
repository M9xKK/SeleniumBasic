import dev.failsafe.internal.util.Assert;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormTest {

    private static WebDriver driver;
    private final String APP_URL = "http://www.automationpractice.pl/index.php";
    @Test
    void shouldFillFormWithPass()
    {
        driver = getDriver();
        driver.get(APP_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement contactUs_Link = driver.findElement(By.cssSelector("#contact-link>a"));
        contactUs_Link.click();

        WebElement emailAddress_Input = driver.findElement(By.cssSelector("input#email"));
        emailAddress_Input.clear();
        emailAddress_Input.sendKeys("EmailAddress@o2.pl");

        WebElement orderReference_Input = driver.findElement(By.cssSelector("input#id_order"));
        orderReference_Input.clear();
        orderReference_Input.sendKeys("123123");

        WebElement message_TextArea = driver.findElement(By.cssSelector("textarea#message"));
        message_TextArea.clear();
        message_TextArea.sendKeys("Some really long message that i wanted to send. \n Next line of this message \n another line \n ps. goodbye");

        WebElement subjectHeading_dropDownList = driver.findElement(By.cssSelector("select#id_contact"));
        subjectHeading_dropDownList.sendKeys("Customer service");

        WebElement fileUpload_Input = driver.findElement(By.cssSelector("#fileUpload"));
        fileUpload_Input.sendKeys("C:\\Users\\magda\\IdeaProjects\\SeleniumBasic\\src\\test\\resources\\test.txt");

        WebElement submitMessage_Button = driver.findElement(By.cssSelector("#submitMessage"));
        submitMessage_Button.click();

        String expectedMessage = "Your message has been successfully sent to our team.";

        WebElement successfulMessage = driver.findElement(By.cssSelector(".alert-success"));
        String actualMessage = successfulMessage.getText();

        assertThat(actualMessage).isEqualTo(expectedMessage);

//        driver.quit();
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
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-search-engine-choice-screen");
//                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions.addArguments("start-maximized");
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("--disable-search-engine-choice-screen");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                edgeOptions.addArguments("start-maximized");
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-search-engine-choice-screen");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            }
            default -> {
                throw new UnsupportedOperationException("Unsupported browser selected");
            }
        }
        return driver;
    }
}