package automation;

import com.oragehrm.automation.CommonFunctions;
import com.oragehrm.automation.LoginPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestDataProvider {

    WebDriver driver;

   @Parameters("chrome")
    @BeforeClass
    public void setup(String browser) throws InterruptedException {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(2000);
    }

    @Test(dataProvider = "getLoginTestData")
    public void varifylogin(Object username, Object password, Object status) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String test =status.toString();
        loginPage.login(username.toString(), password.toString());

        //wait the dashboard module landed completly
        Thread.sleep(5000);

        //varify if logged in to application successfully with valid credentials
        if (test.equals("test1")) {
            //locate the dashboard text and get the text

            WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            Thread.sleep(5000);
            String dashboardText = dashboard.getText();
            System.out.println(dashboardText);

            //varify the dashboardtext value
            if (dashboardText.equals("Dashboard")) {
                System.out.println("Successfully landed on dashborad module");
            }
            else {
                throw new Exception("unable login to application");
            }

            //perform logout operation
            loginPage.logout();
            Thread.sleep(5000);
        } else if(test.equals("test2")) {
            String errormsg = driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();

            loginPage.varifyErrorMsg(errormsg);
            driver.navigate().refresh();
            Thread.sleep(5000);
        } else if (test.equals("test3")) {
            Thread.sleep(5000);
          String error1 = driver.findElement(By.xpath("(//span[text()='Required'])[1]")).getText();
          Thread.sleep(7000);
          String error2=driver.findElement(By.xpath("(//span[text()='Required'])[2]")).getText();
          if(error1.equals("Required")&& error2.equals("Required"))
          {
              System.out.println("both blank test case is pass");
          }
          else
          {
              throw new Exception("both blank test case is fail");
          }


        }

    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object[][] obj = new Object[][]{
                {"Admin", "admin123", "test1"},
                {"Admin", "admin", "test2"},
                {"", "", "test3"}
        };
        return obj;
    }
}


