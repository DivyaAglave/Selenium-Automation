package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddNewUser{

    WebDriver driver;
    AddNewUserPage addNewUserPage;
    String error;

    @BeforeClass
    public void lounchBrouser() throws Exception {
        CommonFunctions functions=new CommonFunctions(driver);
        driver = functions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/daglave");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        addNewUserPage = new AddNewUserPage(driver);
        addNewUserPage.login();
    }

    @Test(dataProvider = "GetData")
    public void AdUser(Object firstName, Object lastName, Object mailId, Object status) throws Exception {
        //click on user Module
        driver.findElement(By.xpath("(//div[text()='Users'])[1]")).click();
        Thread.sleep(8000);
        //send Information to userInformation method
        addNewUserPage.userInformation(firstName.toString(), lastName.toString(), mailId.toString());
        String test = status.toString();
        if (test.equals("test1")) {
            //click on save and Invitation element
            driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
            Thread.sleep(5000);
            //click on
            driver.findElement(By.xpath("(//span[text()='Close'])[1]")).click();
            String newuser= driver.findElement(By.xpath("//div[text()='New User']")).getText();
            if (newuser.equals("New User"))
            {
                System.out.println("test1 is pass with valid credentials");
            }
            else {
                throw new Exception("test1 is fail with valid credentials");
            }
        }
        else
        {
            //click on save and Invitation element
            driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
            if(test.equals("test2"))
            {   //click on save and Invitation element
                driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
                //get error msg
                error=driver.findElement(By.xpath("(//div[text()='cannot be empty'])[6]")).getText();
                //click on cansal
                driver.findElement(By.xpath("(//div[text()='Cancel'])[8]")).click();
                driver.switchTo().alert().accept();


                if (error.equals("cannot be empty"))
                {
                    System.out.println("test2 with invalid credential is pass");
                }
                else {
                    throw new Exception("test2 with invalid credential is fail");
                }
            }
            if (test.equals("test3"))
            {//click on save and Invitation element
                driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
                //get error msg
                error=driver.findElement(By.id("createUserPanel_lastNameEmptyError")).getText();
                //click on cansal
                driver.findElement(By.xpath("(//div[text()='Cancel'])[8]")).click();
                driver.switchTo().alert().accept();
                if (error.equals("cannot be empty"))
                {
                    System.out.println("test3 with invalid credential is pass");
                }
                else {
                    throw new Exception("test3 with invalid credential is fail");
                }

            }
            if (test.equals("test4"))
            {  //click on save and Invitation element
                driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
                //get error msg
                error= driver.findElement(By.id("createUserPanel_emailEmptyError")).getText();
                //click on cansal
                driver.findElement(By.xpath("(//div[text()='Cancel'])[8]")).click();
                driver.switchTo().alert().accept();

                if (error.equals("cannot be empty")) {
                    System.out.println("test4 with invalid credential is pass");
                }
                else
                {
                    throw new Exception("test3 with invalid credential is fail");
                }
            }
            if (test.equals("test5"))
            {
                //click on save and Invitation element
                driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
                //get error msg
                String error1=driver.findElement(By.xpath("(//div[text()='cannot be empty'])[6]")).getText();
                String error2=driver.findElement(By.id("createUserPanel_lastNameEmptyError")).getText();
                String error3=driver.findElement(By.id("createUserPanel_lastNameEmptyError")).getText();
                //click on cansal
                driver.findElement(By.xpath("(//div[text()='Cancel'])[8]")).click();

                if (error1.equals("cannot be empty")&& error2.equals("cannot be empty") && error3.equals("cannot be empty"))
                {System.out.println("test5 with invalid credential is pass");
                }
                else
                {
                    throw new Exception("test5 with invalid credential is fail");

                }
            }


        }
    }


    @DataProvider
    public Object[][] GetData ()
    {
        Object[][] obj = new Object[][]{
                {"Divya", "Aglave", "aglavedivya1@gmail.com", "test1"},
                {"","Aglave", "aglavedivya1@gmail.com", "test2"},
                {"Divya", "", "aglavedivya1@gmail.com", "test3"},
                {"Divya", "Aglave", "", "test4"},
                {"", "", "", "test5"},

        };
        return obj;
    }
}

