package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    private Logger logger = LoggerFactory.getLogger(HomePage.class);
    @FindBy(css="#contact-link>a")
    WebElement contactUs_Link;  //To samo co ponizej ogarniete przez FindBy
//    WebElement contactUs_Link = driver.findElement(By.cssSelector("#contact-link>a"));

    public HomePage cotanctUsClick(){
        contactUs_Link.click();
        logger.info("Contact as link clicked properly");
        return this;
    }

}
