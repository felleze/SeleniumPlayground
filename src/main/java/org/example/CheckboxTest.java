package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // 1️⃣ Locate the FIRST checkbox
        WebElement firstCheckbox =
                driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        firstCheckbox.click();

        Thread.sleep(1000);
        System.out.println("Checkbox selected? " + firstCheckbox.isSelected());
        //uncheck
        firstCheckbox.click();
        Thread.sleep(1000);
        System.out.println("Checkbox selected after uncheck? " + firstCheckbox.isSelected());
        List<WebElement> nrOfCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(nrOfCheckboxes.size());






    }


}
