import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormAdvancedTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(FillFormAdvancedTest.class);

    @Test
    void fillFormAdvancedScenario(){

        WebElement contactUs_Link = driver.findElement(By.cssSelector("#contact-link>a"));
        contactUs_Link.click();
        logger.info("Contact as link clicked properly");

        WebElement emailAddress_Input = driver.findElement(By.cssSelector("input#email"));
        emailAddress_Input.clear();
        emailAddress_Input.sendKeys("EmailAddress@o2.pl");
        logger.info("Email address entered");

        WebElement orderReference_Input = driver.findElement(By.cssSelector("input#id_order"));
        orderReference_Input.clear();
        orderReference_Input.sendKeys("123123");
        logger.info("Order reference submited");

        WebElement message_TextArea = driver.findElement(By.cssSelector("textarea#message"));
        message_TextArea.clear();
        message_TextArea.sendKeys("Some really long message that i wanted to send. \n Next line of this message \n another line \n ps. goodbye");
        logger.info("Message inserted into text area");

        WebElement subjectHeading_dropDownList = driver.findElement(By.cssSelector("select#id_contact"));
        subjectHeading_dropDownList.sendKeys("Customer service");
        logger.info("Element selected from dropdown list as expected!");

        WebElement fileUpload_Input = driver.findElement(By.cssSelector("#fileUpload"));
        fileUpload_Input.sendKeys("C:\\Users\\magda\\IdeaProjects\\SeleniumBasic\\src\\test\\resources\\test.txt");
        logger.info("File attached to form without hesitation, sir.");

        WebElement submitMessage_Button = driver.findElement(By.cssSelector("#submitMessage"));
        submitMessage_Button.click();
        logger.info("Submit button clicked successfuly");


        String expectedMessage = "Your message has been successfully sent to our team.";

        WebElement successfulMessage = driver.findElement(By.cssSelector(".alert-success"));
        String actualMessage = successfulMessage.getText();
        logger.info("Expected mesage: " + expectedMessage);
        logger.info("Actual message: " + actualMessage);

        assertThat(actualMessage).isEqualTo(expectedMessage);
        logger.info("Assertions reslved");
    }
}
