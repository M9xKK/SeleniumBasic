package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CotanctUsVerificationPage {
    private Logger logger = LoggerFactory.getLogger(CotanctUsVerificationPage.class);

    @FindBy(css=".alert-success")
    WebElement successfulMessage;

    public CotanctUsVerificationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String readSuccessfulMessageFromVerificationPage()
    {
        String successfulMessageText = successfulMessage.getText();
        logger.info("Alert message is: " + successfulMessageText);
        return successfulMessageText;
    }


}
