package automation;


import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.Set;

public class Assignment {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        CommonFunctions commonFunctions = new CommonFunctions(driver);
        driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        WebElement miniTv = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
        Actions actions = new Actions(driver);
        actions.contextClick(miniTv).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();


        System.out.println("Amazon page tab tile(1st tab) : " + driver.getTitle());
        String id_1st_tab = driver.getWindowHandle();
        System.out.println("Current window id :" + id_1st_tab);
        Set<String> allWindowid = driver.getWindowHandles();
        System.out.println(allWindowid);

        for (String id : allWindowid) {
            if (!id.equals(id_1st_tab)) {
                System.out.println("second tab id : " + id);
                driver.switchTo().window(id);
                System.out.println("2nd window title : " + driver.getTitle());
                driver.close();
                driver.switchTo().window(id_1st_tab);
                //Print title of 1st page
                System.out.println("1st tab title : " + driver.getTitle());
                driver.quit();
            }
        }

    }
}


