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
        contactUsPage.enterMessageInTextArea(testData.getMessages().getString_short());
        contactUsPage.enterEmailAddress(testData.getUserSettings().getEmail());
        contactUsPage.attachFile(testData.getUserSettings().getPath());
        contactUsPage.enterOrderReference(testData.getMessages().getNumerical_short());
        contactUsPage.selectElementsFromDropDownList("Customer service");
        contactUsPage.clickSubmitMessageButton();
        String actualMessage = contactUsVerificationPage.readSuccessfulMessageFromVerificationPage();
        logger.info("Expected mesage: " + expectedMessage);
        logger.info("Actual message: " + actualMessage);
        logger.info(testData.getSettings().getBrowser());

        assertThat(actualMessage).isEqualTo(expectedMessage);
        logger.info("Assertions reslved");
        //dodac zmienne zamiast danych przekazanych bezposrednio do metod.
    }
}

