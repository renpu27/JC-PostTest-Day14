package com.juaracoding.posttest14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Formy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("Get URL : " + url);

        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("navbar-brand")).getText();
        System.out.println("Title Page : " + title);

        driver.findElement(By.id("first-name")).sendKeys("Asep");
        System.out.println("First Name - Filled");

        driver.findElement(By.id("last-name")).sendKeys("Surasep");
        System.out.println("Last Name - Filled");

        driver.findElement(By.id("job-title")).sendKeys("Cleaning Service");
        System.out.println("Job Title - Filled");

        driver.findElement(By.xpath("//*[@id=\"radio-button-1\"]")).click();
        System.out.println("Education Level - Selected");

        js.executeScript("window.scrollBy(0, 500)");
        System.out.println("=== Scroll ===");

        driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]")).click();
        System.out.println("Sex - Selected");

        WebElement selectExp = driver.findElement(By.id("select-menu"));
        Select exp = new Select(selectExp);
        exp.selectByIndex(4);
        System.out.println("Years Of Experience - Selected");

        driver.findElement(By.id("datepicker")).sendKeys("23/02/2023");
        System.out.println("Date - Filled");

        System.out.println("=== Delay 3 Seconds ===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Form - Submitted");

        System.out.println("=== Delay 3 Seconds ===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
