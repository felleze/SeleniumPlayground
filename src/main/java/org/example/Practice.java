package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption1")).click();

        String checkBoxText = driver
                .findElement(By.id("checkBoxOption1"))
                .getAttribute("value");


        System.out.println("Checkbox value: " + checkBoxText);

        WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByValue(checkBoxText);

        driver.findElement(By.cssSelector("#name")).sendKeys(checkBoxText);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        System.out.println(alertText.contains(checkBoxText));

    }
}
