package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DatePickerExamples {
    public static void main(String[] args) throws InterruptedException {
        //get current date of month
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("day of month is: " + dayOfMonth);

        String currentMonth = LocalDateTime.now().getMonth().name();
        String acutalCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();
        System.out.println("current month is: " + acutalCurrentMonth);

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("Stable");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://online.actitime.com/cybersuccess7/");

        driver.findElement(By.id("username")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.name("pwd")).sendKeys("Test@1234");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(2000);

        //click on task

        WebElement task = driver.findElement(By.xpath("//div[@id='container_tasks']/following-sibling::div"));
        task.click();
        Thread.sleep(5000);

        //add project
        ////driver.findElement(By.xpath("//div[text()='Flight operations']")).click();
       // Thread.sleep(2000);

        driver.findElement(By.xpath("//div[text()='Joda Consulting Inc']/preceding::div[text()='Spaceship building']")).click();
        Thread.sleep(5000);

        //click on add task button
        driver.findElement(By.xpath("//div[@class='rightContainer']")).click();
        Thread.sleep(5000);

        //click on set up deadline
        driver.findElement(By.xpath("//div[@class='detailsRow']/descendant::div[text()='Set up deadline']")).click();
        String monthXpath = "//td[starts-with1(!title,'" + acutalCurrentMonth + "')]/div";
        Thread.sleep(2000);
        System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));
        Thread.sleep(2000);
        for (WebElement dayElement : days) {
            String day = dayElement.getText();
            System.out.println(day);

            if (day.equals(String.valueOf(dayOfMonth))) {
                dayElement.click();
            }
        }
    }
}











