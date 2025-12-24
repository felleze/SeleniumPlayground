package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class UITest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("leza");
        driver.findElement(By.name("email")).sendKeys("leza@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");

        WebElement checkbox = driver.findElement(By.id("exampleCheck1"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());

        Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        dropdown.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("12011994");

        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        driver.quit();

    }
}
