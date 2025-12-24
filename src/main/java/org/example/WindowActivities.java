package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://gooogle.com");
        driver.navigate().to("http://apple.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
