package simpleTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test1 {
    public WebDriver driver;

    @Test
    public void main() {
        WebElement element = null;
        driver.findElement(By.id("log")).sendKeys("testuser");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
        try {
            element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
    }

    @BeforeMethod

    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.store.demoqa.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }

    @AfterMethod

    public void afterMethod() {
        driver.quit();
    }
}
