package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("div[id='start'] button")).click();
        /*The wait is tied to the driver instance.
        * Maximum time to wait for a condition to be true
        * Check the condition every 3 seconds instead of constantly
        * While waiting, ignore exceptions like "element not found"
        * is more flexible than WebDriverWait*/
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        /*This waits until the function returns a non-null WebElement
        * inds the element that will appear after the loading finishes
        *Checks if it is visible on the page
        *  If visible → return the element (foo now holds it)
        * If not → return null → wait continues polling*/
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("div[id='finish'] h4"));
                } else {
                    return null;
                }
            }
        });


    }
}
