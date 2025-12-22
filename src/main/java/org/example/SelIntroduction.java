package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
    public static void main(String[] args) throws InterruptedException {
        /*Selenium will invoke ChromeDriver.exe
        * Step to invoke Chrome Driver
        * For firefox
        *System.setProperty("webdriver.chorme.driver","C:\\Browser drivers\\chromedriver.exe");
         */
        System.setProperty("webdriver.chrome.driver","C:\\Browser drivers\\chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://firefox.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        /*diff between quit and close*/
        driver.close();
        driver.quit();


    }


}
