package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        WebElement checkbox =
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));

        System.out.println("Before click: " + checkbox.isSelected());

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        System.out.println("After click: " + checkbox.isSelected());
    }

}
