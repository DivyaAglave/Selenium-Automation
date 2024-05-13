package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindLinks {
    static WebDriver driver;
        public static void main(String[] args) {
            CommonFunctions commonFunctions = new CommonFunctions(driver);
           driver = commonFunctions.launchBrowser("chrome");
            driver.get("https://www.amazon.in/");

            List<WebElement> webElementList = driver.findElements(By.tagName("a"));

            //itrate through the list of get elemnts

            for(WebElement element:webElementList)
            {
                String link=element.getAttribute("href");
                if(link != null && !link.equals("javascript:void(0)")){
                    System.out.println(link);
                }
            }
        }
    }


