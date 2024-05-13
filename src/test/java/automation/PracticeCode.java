package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PracticeCode {
static WebDriver driver;


    public static void main(String[] args) throws InterruptedException
    {
        CommonFunctions commonFunctions=new CommonFunctions(driver);
         driver=commonFunctions.launchBrowser("chrome");
        //navigate the URL
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")),"aglavedivya1@gmail.com").build().perform();
        //enter password
        actions.sendKeys(driver.findElement(By.name("pwd")),"N4mn@YMa").build().perform();
            //loginbutton
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();


        //click task
      //  actions.click(driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div"))).build().perform();

      Thread.sleep(5000);


        WebElement tasktab=driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]"));
        tasktab.click();
        Thread.sleep(2000);

        actions.click(driver.findElement(By.xpath("//div[@class='unfilteredContainer']/descendant::div[text()='Spaceship building'][1]"))).build().perform();
         Thread.sleep(2000);

        List<WebElement> tasks=driver.findElements(By.xpath("//tr[contains(@class,'taskRow')]/td[2]//div[@class='title']"));

       for(WebElement element:tasks) {
           if(element.isDisplayed())
           {
               System.out.println(element.getText());
           }else {

               //scroll till driver is able to see the elemts on webpage

               //Actions actionss=new Actions(driver);
               actions.scrollToElement(element).build().perform();
               System.out.println(element.getText());


              //
               driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();
               Thread.sleep(5000);
                //move to
               driver.findElement(By.xpath("//div[@class='bulkOperationsPanel']/descendant::div[3]")).click();
               Thread.sleep(2000);

               //select cutomer

               driver.findElement(By.xpath("//div[@class='comboboxButton']//div[text()='- Select Customer -']")).click();
               Thread.sleep(2000);
                 //project as i big bank company
                   driver.findElement(By.xpath("//div[@class='itemRow cpItemRow '][1][text()='Big Bang Company']")).click();
               Thread.sleep(2000);


               //select project
               driver.findElement(By.xpath("//div[@class='comboboxButton']//div[text()='- Select Project -']")).click();


               driver.findElement(By.xpath("//div[@class='itemRow cpItemRow '][1][text()='Flight operations']")).click();
                 Thread.sleep(2000);


                 //move button
               driver.findElement(By.xpath("(//div[text()='Move'])[3]")).click();
               Thread.sleep(2000);




           }




       }





    }
}








