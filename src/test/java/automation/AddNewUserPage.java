package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewUserPage {
    WebDriver driver;
    public AddNewUserPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public  void login() throws Exception{
        //locate username element and enter username
        driver.findElement(By.id("username")).sendKeys("aglavedivya1@gmail.com");

        //locate password element and enter password
        driver.findElement(By.name("pwd")).sendKeys("N4mn@YMa ");

        //locate login element and click
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(8000);
    }
    public void userInformation(String firstName,String lastName,String mailId)throws Exception
    {   Thread.sleep(8000);
        //click on newUser element
        driver.findElement(By.xpath("//div[text()='New User']")).click();
        Thread.sleep(5000);
        //send First Name
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(firstName);
        //enter Last Name
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(lastName);
        //enter mailId
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys(mailId);

    }
}

