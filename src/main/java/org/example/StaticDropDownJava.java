package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StaticDropDownJava {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        WebElement incrementButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
        incrementButton.click();


        for (int i = 0; i<4; i++) {
            incrementButton.click();
        }

    }
}
