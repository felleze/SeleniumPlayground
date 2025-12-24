package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

        Set<String> abc = driver.getWindowHandles();

        Iterator<String> it = abc.iterator();

        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
    }
}
