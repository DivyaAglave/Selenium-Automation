package automation;

//import jdk.jfr.snippets.Snippets;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiSelectDropDownExample {
    public static void main(String[] args)
    {
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.get("//https://letcode.in/dropdowns");



        WebElement dropdown=driver.findElement(By.id("superheros"));

    }
}
