package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class actiTimeLogin {
    public static void main(String[]args) throws InterruptedException {
        //launch chrome Browser
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        //create an instance of chrome driver and pass chrome option instance
        //referance  to chromedriver constructor

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("http://online.actitime.com/cybersuccess7/");
        Thread.sleep(5000);


        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("cybersuccess@yopmail.com");
        Thread.sleep(5000);


        WebElement password= driver.findElement(By.name("pwd"));
        password.sendKeys("Test@1234");

        WebElement login=driver.findElement(By.xpath("//div[text()='Login ']"));
        login.click();
        Thread.sleep(10000);

        //click on tasks
        WebElement task=driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div"));
        task.click();
        Thread.sleep(5000);

        //navigate to checkbox in 3d modeling
        driver.findElement(By.xpath("//div[@class='createdTasksTableContainer']/following::div[3]")).click();
        Thread.sleep(5000);

        //navigate to chnage status
        driver.findElement(By.xpath("//div[text()='Change Status']")).click();
        Thread.sleep(5000);

        //navigate to drop down
        driver.findElement(By.xpath("//div[text()='New Status:']/following::div[7]")).click();
        Thread.sleep(5000);

        //navigate to planning option and click on it

        WebElement planning=driver.findElement(By.xpath("//div[text()='click to view project settings']/following::div[28]"));
        planning.click();
        Thread.sleep(5000);

        WebElement apply= driver.findElement(By.xpath("//span[text()='Apply']"));
        apply.click();


    }
    }
