import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ContactUsPage;
import pages.CotanctUsVerificationPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormPOMTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(FillFormPOMTest.class);
    private String expectedMessage = "Your message has been successfully sent to our team.";

    @Test
    void shouldSendFormWithPOM()
    {

        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        CotanctUsVerificationPage contactUsVerificationPage = new CotanctUsVerificationPage(driver);

        homePage.cotanctUsClick();
        contactUsPage.enterMessageInTextArea("Some really long text \n with many lines \n thanks!");
        contactUsPage.enterEmailAddress("myemail@o2.pl");
        contactUsPage.attachFile("C:\\Users\\magda\\IdeaProjects\\SeleniumBasic\\src\\test\\resources\\test.txt");
        contactUsPage.enterOrderReference("123456");
        contactUsPage.selectElementsFromDropDownList("customer service");
        contactUsPage.clickSubmitMessageButton();
        String actualMessage = contactUsVerificationPage.readSuccessfulMessageFromVerificationPage();
        logger.info("Expected mesage: " + expectedMessage);
        logger.info("Actual message: " + actualMessage);

        assertThat(actualMessage).isEqualTo(expectedMessage);
        logger.info("Assertions reslved");
        //dodac zmienne zamiast danych przekazanych bezposrednio do metod.
    }
}
