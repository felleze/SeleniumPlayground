package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Browser drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://youtube.com");

        driver.findElement(
                By.cssSelector("button[aria-label^='Accept']")
        ).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("search_query"))
        );

        searchInput.click();
        searchInput.sendKeys("Nirvana Something In The Way");
        searchInput.sendKeys(Keys.ENTER);

        WebElement firstVideo = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[@id='video-title'])[1]")
                )
        );
        firstVideo.click();
    }
}
