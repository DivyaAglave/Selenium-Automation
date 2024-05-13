package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverMethods {
    public static void main(String[]args) throws InterruptedException
    {
        //launch chrome Browser
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        //create an instance of chrome driver and pass chrome option instance
        //referance  to chromedriver constructor

        WebDriver  driver=new ChromeDriver(options);

//      driver.navigate().to("https://opensource-demo.orangehrmlive.com");
//        Thread.sleep(5000);
//
//        //get the title of current page
//
//        String title= driver.getTitle();
//        System.out.println(title);
//
//        //get currentURL
//        String currenturl=driver.getCurrentUrl();
//        System.out.println(currenturl);
//        Thread.sleep(10000);
//
//        LoginPage loginPage=new LoginPage(driver);
//    //login wwith valid username and pass
//        loginPage.login("admin","admin123");
//
//        Thread.sleep(5000);
//    //navigate PIM module
//        driver.findElement(By.xpath("//span[text()='PIM']")).click();
//        Thread.sleep(10000);

//        WebElement searcheEmpName=driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]"));
//        searcheEmpName.sendKeys("testing course");
//        searcheEmpName.click();
//        Thread.sleep(2000);
//        searcheEmpName.clear();


        //############################################################################################################//

        //navigate to flipcart url

       driver.get("https://www.amazon.in/");
       Thread.sleep(5000);

       WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));

       String placeholder=searchbox.getAttribute("placeholder");
        System.out.println(placeholder);
        Thread.sleep(5000);

        WebElement signin= driver.findElement(By.id("nav-link-accountList"));

        String href=signin.getAttribute("href");
        System.out.println(href);
        Thread.sleep(5000);

        String tagname=signin.getTagName();
        System.out.println("tagnme "+tagname);
        Thread.sleep(2000);

        if (searchbox.isDisplayed()){
            searchbox.sendKeys("tv");
            searchbox.clear();
        }







        




    }
}
