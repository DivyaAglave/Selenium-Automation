package automation;

import com.oragehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import  org.testng.annotations.*;


public class OrangehrmTestNG {


    //varify   OrangeHrm Module
    WebDriver driver;

    LoginPage loginPage = new LoginPage(driver);


    @BeforeClass
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
    }

    @Test
    public void logonhrm() throws InterruptedException {

//............Navigate to LoginPage In OrangeHrm....................//

        driver.findElement(By.name("username")).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(20000);
    }

    @Test
    public void pimmodule() throws InterruptedException {


        //..............PIM Module With mendetory fields.......................//
        //click on PIM MOdule.........

        WebElement module = driver.findElement(By.xpath("//span[text()='PIM']"));
        module.click();
        Thread.sleep(2000);

        //Click on ADD Employee //
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(2000);

        //enter first name
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstname.sendKeys("John");
        Thread.sleep(2000);

        //enter middlename
        WebElement middlename = driver.findElement(By.xpath("//input[@name='middleName']"));
        middlename.sendKeys("carole");
        Thread.sleep(2000);

        //enter lastname
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastname.sendKeys("mitchel");
        Thread.sleep(2000);

        //enter empId
        WebElement id = driver.findElement(By.xpath("//label[text()='Employee Id']//following::input[1]"));
        id.sendKeys("12345");
        Thread.sleep(2000);

        //Create A Login Details

        driver.findElement(By.xpath("//input[@type='checkbox']")).isEnabled();
        Thread.sleep(2000);

        driver.findElement((By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(10000);

        WebElement info = driver.findElement(By.xpath("//label[text()='Other Id']//following::input[1]"));
        info.sendKeys("773948");
        Thread.sleep(20000);


    }

}


