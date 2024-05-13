package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class BroswerTabOperations {
    WebDriver driver;
    public void main(String[] args) throws InterruptedException
    {
        CommonFunctions commonFunctions=new CommonFunctions(driver);
        driver=commonFunctions.launchBrowser("chrome");
        driver.get("http://online.actitime.com/cybersuccess7/login.do");
        Thread.sleep(5000);

        WebElement actitime=driver.findElement(By.partialLinkText("actiTIME"));
        Actions actions=new Actions(driver);
        actions.contextClick(actitime).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

        //print the title of the login page
        System.out.println("Title of the login page: "+driver.getTitle());

        //get current tab
        String loginWindow=driver.getWindowHandle();
        System.out.println("login window Id: "+loginWindow);

        //get ids of all tabs
        Set<String> allWindowIds=driver.getWindowHandles();
        System.out.println(allWindowIds);

        //itrate throgh the set and check loginwindowid if it is login id
        //then ignore and print other one
         for(String id:allWindowIds)
         {
             if(!id.equals(loginWindow))
             {
                 System.out.println("second tab "+id);

                 //close the second tab
                 driver.close();

                 //switch control back to login
                 driver.switchTo().window(loginWindow);

                 //print the title
                 System.out.println("current title "+driver.getTitle());
             }
         }
    }
}
