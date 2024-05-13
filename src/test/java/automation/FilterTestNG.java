package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FilterTestNG {

    //varify the task should be treated as filter status

    WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) throws InterruptedException {
        //launch the broswer
        CommonFunctions functions =new CommonFunctions(driver);
        functions.launchBrowser(browser);
        Thread.sleep(2000);
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(2000);
    }

    @Test
    //login to actitime
    public void login() throws InterruptedException {
        driver.findElement(By.id("username")) .sendKeys("aglavedivya1@gmail.com");
        Thread.sleep(2000);
        //password

        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");
        Thread.sleep(2000);

        //Click on LoginButton

        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);

    }
    @Test
    //Navigate the task
    public void task() throws InterruptedException {
        WebElement task = driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div"));
        task.click();
        Thread.sleep(5000);


        //CLICK ON PROJECT
        WebElement project = driver.findElement(By.xpath("//div[@class='unfilteredContainer']/descendant::div[text()='Flight operations'][1]"));
        project.click();
        Thread.sleep(2000);

        //click on filterbstatus

        //span[text()='Add filters']
        WebElement addfilter=driver.findElement(By.xpath("//span[text()='Add filters']"));
        addfilter.click();
        Thread.sleep(2000);

        //apply status checkbox

        //div[text()='Apply']
        driver.findElement(By.xpath("//div[text()='Apply']")).click();
        Thread.sleep(20000);



//        //navigate to statuses
//        driver.findElement(By.xpath("//div[@class='filtersContainer']/descendant::span[2]")).click();
//               Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Statuses']//following::div[@class='img'][1]")).click();
        //click on select on dropdown
        driver.findElement(By.xpath("//input[@placeholder='Start typing a name...']/following::span[1]")).click();
        //click on select all radio button
        driver.findElement(By.xpath("//input[@value='selected']")).click();
        Thread.sleep(5000);
        //click on new option
        driver.findElement(By.xpath("//span[text()='Open tasks']/following::span[1]")).click();
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        //click on select all box
        driver.findElement(By.xpath("//span[text()='Statuses']//following::div[@class='img'][1]")).click();
        Thread.sleep(5000);
        //click on status element
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();
        Thread.sleep(5000);
        //click on option
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[2]")).click();
        Thread.sleep(5000);
        //click on new option
        driver.findElement(By.xpath("//div[text()='click to view project settings']/following::div[18]")).click();
        //click on apply
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        Thread.sleep(5000);
        //click on select all box
        driver.findElement(By.xpath("//span[text()='Statuses']//following::div[@class='img'][1]")).click();
        Thread.sleep(5000);
    }



    }

