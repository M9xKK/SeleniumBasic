import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ContactUsPage;
import pages.CotanctUsVerificationPage;
import pages.HomePage;

public class FillFormPOMTest extends BaseTest {

    @Test
    void shouldSendFormWithPOM()
    {
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();
        CotanctUsVerificationPage contactUsVerificationPage = new CotanctUsVerificationPage();

        homePage.cotanctUsClick();
        contactUsPage.enterMessageInTextArea("Some really long text \n with many lines \n thanks!");
        contactUsPage.enterEmailAddress("myemail@o2.pl");
        contactUsPage.attachFile("C:\\Users\\magda\\IdeaProjects\\SeleniumBasic\\src\\test\\resources\\test.txt");
        contactUsPage.enterOrderReference("123456");
        contactUsPage.selectElementsFromDropDownList("customer service");
        contactUsPage.clickSubmitMessageButton();
        contactUsVerificationPage.readSuccessfulMessageFromVerificationPage();
    }
}
