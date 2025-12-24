package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[2]/div[2]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));


        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;

                }


            }

        }
    }
}
