package com.oragehrm.automation;

import com.graphbuilder.math.FuncMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class CommonFunctions {
    WebDriver driver;

    {
    }

    public CommonFunctions(WebDriver driver) {
    }

    public WebDriver launchBrowser(String name) {
        if (name.toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            options.setBrowserVersion("121");
            options.addArguments("--remote-allow-origins=*");
            //driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void waitForElementPresents(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementtoClickable(String element) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
    }

    public void fluentWait(WebDriver driver, By by) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(Exception.class);
        Function<WebDriver, WebElement> function = (var) -> {
            System.out.println("waiy until element is avilable");
            return driver.findElement(by);
        };
        fluentWait.until(function);
    }

}
