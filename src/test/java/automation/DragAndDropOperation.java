package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropOperation {
    static WebDriver driver;

    public static void main(String[] args) {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        WebDriver driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://www.globalsqa.com/demo-site/draganddrop");

        //switch control from webpage to iframe

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));


        //switch to iframe
        driver.switchTo().frame(iframeElement);

        Actions actions = new Actions(driver);
        WebElement srcelement = driver.findElement(By.xpath("//ul[@id='gallery']/li[1]/img"));

        WebElement dstelemet = driver.findElement(By.id("trash"));

        //perform drag and drop operation

        actions.clickAndHold(srcelement).release(dstelemet).build().perform();

        actions.doubleClick(srcelement).build().perform();

        //switch control back to main page

        driver.switchTo().defaultContent();

        //print title of wepage

        String title = driver.getTitle();
        System.out.println(title);
    }


    }


