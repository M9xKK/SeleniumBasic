import base.BaseWebTableTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTableSimpleTest extends BaseWebTableTest {
    private Logger logger = LoggerFactory.getLogger(WebTableSimpleTest.class);

    @Test
    @DisplayName("Verify if WebTable capitals are properly populated.")
    void shouldCheckCapitalInWebTable(){
        String searchCountry = "Burkina Faso";
        String expectCapital = "Ouagadougou";
        String actualCapital = getCapitalForTheCountry(searchCountry);

        assertThat(actualCapital).isEqualTo(expectCapital);
    }

    private String getCapitalForTheCountry(String country) {
        List<WebElement> rows = driver.findElements(By.cssSelector("#countries>tbody>tr"));
        int size = rows.size();
        logger.info("Wielkosc tablicy: " + size);

        int rowCount = 0;
        for (WebElement row: rows){
            if (row.getText().contains(country)){
                break;
            }

            rowCount++;
        }
        int indexOfCountry = rowCount + 1;
        logger.info("Row number: " + (rowCount+1) + " For country " + country);

        navigateToElement(rows.get(indexOfCountry+5));

        WebElement capitalOfCountry = driver.findElement(By.cssSelector("#countries>tbody>tr:nth-child("+indexOfCountry+")>td:nth-child(3)"));
//        navigateToElement(capitalOfCountry);

        logger.info("Capital of " +country+ " is " + capitalOfCountry.getText());
        return capitalOfCountry.getText();
    }

    @Test
    @DisplayName("Should find and select checkbox")
    void shouldSelectCheckbox()
    {
        //Check poland checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".hasVisited[type='checkbox']"));
        //Here we might use previously created method for selecting specific element based on its name
        WebElement checkbox = findCheckbox(checkboxes, 139);
        navigateToElement(checkboxes.get(145));
        clickCheckbox(checkbox);

        assertThat(checkbox.isSelected()).isTrue();
    }

    private void navigateToElement(WebElement element){
        new Actions(driver).scrollToElement(element).perform();
        logger.info("Scroll to the element");
    }

}
