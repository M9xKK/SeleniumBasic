package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactUsPage {
    private Logger logger = LoggerFactory.getLogger(ContactUsPage.class);

    @FindBy(css="id_contact")
    WebElement subjectHeading_dropDownLis;

    @FindBy(css="input#email")
    WebElement emailAddress_Input;

    @FindBy(css="input#id_order")
    WebElement orderReference_Input;

    @FindBy(css="textarea#message")
    WebElement message_TextArea;

    @FindBy(css="#fileUpload")
    WebElement fileUpload_Input;

    @FindBy(css="#submitMessage")
    WebElement submitMessage_Button;

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public ContactUsPage selectElementsFromDropDownList(String customerService)
    {
        Select select = new Select(subjectHeading_dropDownLis);
        select.selectByVisibleText(customerService);
        logger.info("Element selected from dropdown list as expected!");
        return this;
    }

    public ContactUsPage enterEmailAddress(String emailAddress)
    {
        emailAddress_Input.clear();
        emailAddress_Input.sendKeys(emailAddress);
        logger.info("Email address entered");
        return this;
    }

    public ContactUsPage enterOrderReference(String orderReferenceNumber)
    {
        orderReference_Input.clear();
        orderReference_Input.sendKeys(orderReferenceNumber);
        logger.info("Order reference submited");
        return this;
    }

    public ContactUsPage enterMessageInTextArea(String messageTextArea)
    {
        message_TextArea.sendKeys(messageTextArea);
        logger.info("Message inserted into text area");
        return this;
    }

    public ContactUsPage attachFile(String path)
    {
        fileUpload_Input.sendKeys(path);
        logger.info("File attached to form without hesitation, sir.");
        return this;
    }

    public ContactUsPage clickSubmitMessageButton()
    {
        submitMessage_Button.click();
        logger.info("Submit button clicked successfuly");
        return this;
    }

}
