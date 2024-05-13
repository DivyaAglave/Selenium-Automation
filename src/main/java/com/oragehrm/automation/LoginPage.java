package com.oragehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void login(String username,String password)
    {
       driver.findElement(By.name("username")).sendKeys(username);
       driver.findElement(By.name("pwd")).sendKeys(password);
       driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public  void logout()
    {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }

    public void varifyErrorMsg(String msg) throws Exception
    {
        if(msg.equals("Invalid credentials"))
        {
            System.out.println("text passes with valid credentials");
        }
        else{
            throw new Exception("text failed: error msg is nit displayed on login page");
        }
    }
    public void notifyBlank(String msg1) throws Exception
    {
        if(msg1.equals("Required"))
            if (msg1.equals("Required")) {
                System.out.println("Invalid Credintials  Or Blank Credintials ");


            } else {
                throw new Exception("requsired msg is not displayed");
            }
    }

}
