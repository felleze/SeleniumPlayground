package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
        WebElement topFrame =
                driver.findElement(By.cssSelector("frame[name='frame-top']"));

        driver.switchTo().frame(topFrame);
        WebElement middleFrame =
                driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        driver.switchTo().defaultContent();
    }
}
