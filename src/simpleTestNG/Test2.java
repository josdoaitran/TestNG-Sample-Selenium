package simpleTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public WebDriver driver;

    @Test
    public void main() {
        driver.findElement(By.name("firstname")).sendKeys("Lakshay");
        driver.findElement(By.name("lastname")).sendKeys("Sharma");
        driver.findElement(By.id("submit")).click();
    }

    @BeforeMethod

    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
        driver.manage().window().maximize();
    }

    @AfterMethod

    public void afterMethod() {
        driver.quit();
    }
}
