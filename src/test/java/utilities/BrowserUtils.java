package utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static utilities.Driver.driver;

public class BrowserUtils {
    /**
     * This method generates random emails.
     * Ex:
     *   .getRandomEmail(); RETURNS user-12nmfgh-fgh@gmail.com
     */
    public static String getRandomEmail(){
        UUID uuid= UUID.randomUUID();
        return  "user"+uuid+"@gmail.com";
    }
    /**
     * This method takes screenshots .
     * ex:
     *    .takeScreenshot("NameOfScreenshot");
     */
    public  static void takeScreenshot(String testName) throws IOException {
        WebDriver driver= Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+testName+".png";
        File file=new File(path);
        FileUtils.copyFile(screenshot,file);
    }
    /**
     * This method accepts a webElement and a String value to select an option from dropdown by value(attribute value).
     * Ex.
     *    .selectDropdownByValue(WebElement dropdown, String value);
     */
    public  static  void  selectDropdownByValue(WebElement dropdown, String value){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    /**
     * This method will create a WebDriverWait object and wait for certain text
     * to be present in a WebElement
     * Ex.
     *    .waitForTextToBePresentInElement(WebElement element, String expectedText);
     */

    public  static  void waitForTextToBePresentInElement(WebElement element,String expectedText){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.textToBePresentInElement(element,expectedText));

    }
    public  static  void waitForElementToBeClickable(WebElement element){
        /**
         * This method waits for certain text to be present in a WebElement
         *  Ex.
         *       .waitForTextToBeClickable(WebElement element);
         */
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /** This method scrolls down by (num) px.
     * ex:
     *    .scrollDownBy(int numOfPixels):
     */

    public  static  void  scrollDownBy(int numOfPixels){
        JavascriptExecutor jse = ((JavascriptExecutor) Driver.getDriver());
            jse.executeScript("window.scrollBy(0,"+numOfPixels+")");

    }
}

