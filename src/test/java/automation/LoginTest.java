package automation;

//import jdk.internal.classfile.AnnotationElement;
import com.oragehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeGroups;

public class LoginTest {
    public static void main(String[] args) throws Exception {
        //launch the broswer
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        //navigate to URL
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://online.actitime.com/daglave");

        Thread.sleep(1000);


        LoginPage loginPage=new LoginPage(driver);
        //perform login Operation
        loginPage.login("Admin" ,"admin123");

        Thread.sleep(2000);

        WebElement login=driver.findElement(By.xpath("//div[text()='Login ']"));
        login.click();



        Thread.sleep(10000);

        //locate the dashboard text and get the text

        WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText=dashboard.getText();

        System.out.println("dashBoard");
        //verify the dashboardText value
        if (dashboardText.equals("Dashboard")){
            System.out.println("successfully landed on dashboard module");
        }else throw new Exception("unable login to this application");


     //perform logout Operation
        loginPage.logout();

        Thread.sleep(10000);

        //enter invalid username and valid password
        loginPage.login("admin122345656", "admin123");
        Thread.sleep(5000);

       String errorMsg= driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();

       loginPage.varifyErrorMsg(errorMsg);
       driver.navigate().refresh();

       Thread.sleep(5000);



       //enter valid username and invalid password
        loginPage.login("Admin" ,"he3663f6t");
        Thread.sleep(5000);
      //display the invalid credentials msg in cmd
         errorMsg=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
         loginPage.varifyErrorMsg(errorMsg);
         driver.navigate().refresh();
         Thread.sleep(5000);

 //enter bank username and password
         loginPage.login("  ","" );
         Thread.sleep(5000);
  //display the msg required username and password is blank
        String required = driver.findElement(By.xpath("//span[text()='Required']")).getText();
         loginPage.notifyBlank(required);
         driver.navigate().refresh();
         Thread.sleep(2000);

//enter blank username and valid password
         loginPage.login("  ","admin123");
         Thread.sleep(5000);
         required = driver.findElement(By.xpath("//span[text()='Required']")).getText();
         loginPage.notifyBlank(required);
         driver.navigate().refresh();
         Thread.sleep(5000);

    }
}
