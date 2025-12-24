package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment {


    public static void main(String[] args) throws InterruptedException {


        String text = "leza";

        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("http://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        Thread.sleep(1000);

        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1000);

        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(1000);

        driver.switchTo().alert().dismiss();

    }


}