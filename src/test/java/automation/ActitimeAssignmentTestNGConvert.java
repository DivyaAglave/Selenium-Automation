package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActitimeAssignmentTestNGConvert {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/daglave");
    }

    @Test
    public void loginActitime() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("aglavedivya1@gmail.com");


        WebElement password = driver.findElement(By.name("pwd"));
        password.sendKeys("N4mn@YMa");

        WebElement login = driver.findElement(By.xpath("//div[text()='Login ']"));
        login.click();
        Thread.sleep(2000);
        //cllick on task

        WebElement task = driver.findElement(By.xpath("//div[@id='container_tasks']//following::div[1]"));
        task.click();

        WebElement project = driver.findElement(By.xpath("//div[text()='Joda Consulting Inc']/preceding::div[text()='Flight operations']"));
        project.click();
        Thread.sleep(2000);

        WebElement clickbutton = driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[1]"));
        clickbutton.click();
        Thread.sleep(2000);


        WebElement changestatus = driver.findElement(By.xpath("//div[text()='Change Status']"));
        changestatus.click();
        Thread.sleep(20000);


        driver.findElement(By.xpath("//div[text()='New'][5]")).click();
    }
}



