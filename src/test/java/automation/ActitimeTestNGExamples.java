package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActitimeTestNGExamples {

    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(20000);
    }

    @Test
    public void login() throws InterruptedException {
        //enter valid username and password
        driver.findElement(By.id("username")).sendKeys("aglavedivya1@gmail.com");

        Thread.sleep(2000);

        //password
        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");
        Thread.sleep(2000);

        //Click on LoginButton
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(20000);

        driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div")).click();
        Thread.sleep(2000);

        //click on add button
        WebElement addbutton = driver.findElement(By.xpath("//div[text()='Add New']"));
        addbutton.click();
        Thread.sleep(2000);

        //Add Customer
        WebElement customer = driver.findElement(By.xpath("//div[text()='+ New Customer']"));
        customer.click();
        Thread.sleep(5000);

        //enter Customer Name In info
        driver.findElement(By.xpath("//div[@class=\"customerInfoDiv\"]//child::input[1]")).sendKeys("Maindlabz Private Limited");
        Thread.sleep(3000);



        //Enter Customer Description

        driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("This is WebDevlopment Company which is Prefer to HTML,CSS and so on");
        Thread.sleep(2000);

        //click on Create Cutomer

        WebElement clickcustomer = driver.findElement(By.xpath("//div[text()='Create Customer']"));
        clickcustomer.click();
        Thread.sleep(3000);
    }
    @Test
    public void errormsg( String errormsg) throws Exception {
       if (errormsg.equals("Customer with the specified name already exists"))
       {
           System.out.println("Duplicate Cutomer test is scuccefully");
       }
       else
       {
           throw new Exception("user can create customer by duplicate information");
       }
       }
    }











