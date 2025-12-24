package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestivedropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> indCountry = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
        for(WebElement s: indCountry) {
           if(s.getText().equalsIgnoreCase("India")) {
               s.click();
               break;
           }
        }
    }
}
