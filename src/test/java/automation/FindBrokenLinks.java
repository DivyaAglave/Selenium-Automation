package automation;

import com.oragehrm.automation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class FindBrokenLinks {
    static WebDriver driver;
    public  static void main(String[] args)throws IOException
    {
        CommonFunctions commonFunctions=new CommonFunctions(driver);
       driver=commonFunctions.launchBrowser("chrome");
        driver.get("https://www.amazon.in/");

        List<WebElement>WebelementsList=driver.findElements(By.tagName("a"));

        //irerate throgh the list to get elemet
        for(WebElement element:WebelementsList)
        {
            String link=element.getAttribute("href");
            if(link!=null && !link.startsWith("javascript")) {
                //convert string url into acutal url
                URL url = new URL(link);
                //opening the connection for an url using part
                URLConnection connection = url.openConnection();

                //cast connection var in to Httpurlconnection
                HttpURLConnection urlConnection = (HttpURLConnection) connection;

                //hit the url
                urlConnection.connect();
                //get the status code
                int status = urlConnection.getResponseCode();
                if (status != 200) {
                    System.out.println("broken url: " + status + " " + link);
                }


            }

        }

    }
}
