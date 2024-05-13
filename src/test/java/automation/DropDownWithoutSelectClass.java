package automation;

import com.oragehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDownWithoutSelectClass {
    public static void main(String [] args) throws InterruptedException
    {
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage=new LoginPage(driver);
        Thread.sleep(10000);

        loginPage.login("admin","admin123");
        Thread.sleep(5000);

        //click on PIM module
  driver.findElement(By.xpath("//span[text()='PIM']")).click();
  Thread.sleep(5000);

  //click on job title drondown
        driver.findElement(By.xpath("//div[@class='oxd-form-row']//div[6]//i")).click();
        Thread.sleep(2000);
        //select autpmatiob tester from the dropdown

        driver.findElement(By.xpath("//div[@role='listbox']//div[3]//span")).click();
        Thread.sleep(2000);

    }
}
