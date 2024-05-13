package automation;


import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.awt.*;

public class LoginPageTestNG {
   // CommonFunctions commonFunctions=new CommonFunctions();
    WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws InterruptedException {
        CommonFunctions functions = new CommonFunctions(driver);
        WebDriver driver1 =functions.launchBrowser(browser);
        driver.get("https://online.actitime.com/daglave");
        Thread.sleep(2000);
    }

    @Test
    public void login1() throws InterruptedException {
        // Find and Enter a Valid Username and Password

        //username
      driver.findElement(By.id("username")) .sendKeys("aglavedivya1@gmail.com");

        //password

        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");
        Thread.sleep(2000);

        //Click on LoginButton

        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);

    }
    @Test
    public void login2() throws Exception {
        //enter valid username and invalid password
        driver.findElement(By.id("username")) .sendKeys("aglavedivya1@gmail.com");
        Thread.sleep(2000);
        //password

        driver.findElement(By.name("pwd")).sendKeys("hgdtdftdhcv");
        Thread.sleep(2000);

        //Click on LoginButton

        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);

    }
    @Test
    public void login3() throws InterruptedException{

        //enter invalid username and valid password

        driver.findElement(By.id("username")) .sendKeys("aglavedivya1");
        Thread.sleep(2000);
        //password

        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");
        Thread.sleep(2000);

        //Click on LoginButton

        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);

    }
    @Test
    public  void login4() throws InterruptedException {
        //enter invalid username invalid password

        driver.findElement(By.id("username")) .sendKeys("aglavedivya1");
        Thread.sleep(2000);
        //password

        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa");
        Thread.sleep(2000);

        //Click on LoginButton

        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);
    }
}



