# 🎥 YouTube Search Automation (Selenium + Java)

Automated browser testing project that simulates a real user searching for a video on **YouTube**, accepting cookies, and clicking the first result built with **Java, Maven, Selenium WebDriver, and ChromeDriver**.

---

## Tech Stack

- Java
- Maven
- Selenium WebDriver
- Google Chrome
- ChromeDriver

---

## Project Overview

This project demonstrates how to automate a real-world web application (YouTube) using Selenium.

### The automation flow:
- Launch Chrome browser
- Navigate to YouTube
- Accept cookie consent popup
- Enter a search query
- Submit search using the ENTER key
- Click the first video result

The project uses **explicit waits** to handle dynamic elements and animations.

---

##  Prerequisites

Make sure the following are installed:

- Java JDK 21
- Maven
- Google Chrome
- ChromeDriver (matching your Chrome version)

Download ChromeDriver:  
https://googlechromelabs.github.io/chrome-for-testing/

---

## Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.39.0</version>
    </dependency>
</dependencies>