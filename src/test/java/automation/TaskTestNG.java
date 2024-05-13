package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TaskTestNG {
    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws InterruptedException {
        CommonFunctions functions =new CommonFunctions(driver);
        WebDriver driver1=functions.launchBrowser(browser);
        Thread.sleep(2000);
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(2000);
    }

    @Test
    public void login1() throws InterruptedException {
        // Find and Enter a Valid Username and Password

        //username
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
    public void task1() throws InterruptedException {
        //Click on task
        WebElement task = driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div"));
        task.click();
        Thread.sleep(5000);

        WebElement project = driver.findElement(By.xpath("//div[@class='unfilteredContainer']/descendant::div[text()='Flight operations'][1]"));
        project.click();
        Thread.sleep(2000);
    }

    @Test
    public void  task2()
    {

    }







}
