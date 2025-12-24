package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginPage {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-save-password-bubble");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Login
        driver.findElement(By.id("username"))
                .sendKeys("rahulshettyacademy");

        driver.findElement(By.id("password"))
                .sendKeys("learning");

        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]"))
                .click();

        // Handle modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        System.out.println(
                driver.findElement(By.cssSelector(".modal-body p")).getText()
        );
        driver.findElement(By.id("okayBtn")).click();

        // Select role from dropdown
        WebElement dropdownElement = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("consult");

        // Accept terms
        WebElement terms = driver.findElement(By.id("terms"));
        if (!terms.isSelected()) {
            terms.click();
        }

        // Sign in
        driver.findElement(By.id("signInBtn")).click();

        // Wait for products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card")));

        // Add all products to cart
        List<WebElement> addButtons =
                driver.findElements(By.cssSelector(".btn.btn-info"));

        for (WebElement button : addButtons) {
            button.click();
        }

        System.out.println("All products added to cart ✅");

        // driver.quit(); // uncomment when done
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
    }
}
