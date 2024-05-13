package com.orangehrm.automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticalTestNGWaits {

    WebDriver driver;
    CommonFunctions commonFunctions;



    @BeforeClass
    public void setup() throws InterruptedException {
         commonFunctions = new CommonFunctions(driver);
        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
    }
    @Test
    public void login() throws InterruptedException {

        commonFunctions.waitForElementPresents(driver, driver.findElement(By.id("username")));

        driver.findElement(By.id("username")) .sendKeys("aglavedivya1@gmail.com");

        //password
        commonFunctions.waitForElementPresents(driver, driver.findElement(By.name("pwd")));
        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");


        //Click on LoginButton
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
Thread.sleep(2000);



       commonFunctions.waitForElementPresents(driver, driver.findElement(By.xpath("//div[text()='Users']")));
        driver.findElement(By.xpath("//div[text()='Users']")).click();
       // commonFunctions.waitElementtoClickable("Users");

//commonFunctions.waitForElementPresents(driver, driver.findElement(By.xpath("//label[@id='ext-gen500']])[1]")));
        driver.findElement(By.xpath("(//label[@id='ext-gen500'])[1]")).click();
 Thread.sleep(2000);

        WebElement alluser = driver.findElement(By.xpath("//div[@id='ext-gen513']"));
        alluser.click();

//        WebElement checkbox= driver.findElement(By.xpath("(//span[@class='checkbox'])[1]"));
//        if(checkbox.isSelected())
//        {
//            checkbox.click();
//        }
//        if (!checkbox.isSelected())
//        {
//            checkbox.click();
//        }
        Thread.sleep(2000);

        Actions actions=new Actions(driver);

        WebElement projectclick = driver.findElement(By.xpath("//span[text()='Users Without Department']"));
        projectclick.click();
        WebElement checkbox= driver.findElement(By.xpath("(//span[@class='checkbox'])[1]"));
        if(checkbox.isSelected())
        {
            checkbox.click();
        }
        if (!checkbox.isSelected())
        {
            checkbox.click();
        }
        Thread.sleep(2000);


        driver.findElement(By.xpath("//span[@id='ext-gen588']")).click();
        Thread.sleep(5000);
       Actions action=new Actions(driver);




      WebElement user = driver.findElement(By.xpath("(//span[text()='Womack, Ashley'])[1]"));
        Thread.sleep(2000);

//        if (user.equals("Womack, Ashley")) {
//            System.out.println("user should be present");
//        } else {
//            throw new Exception ("invalid user");
//        }
    }




    }

