package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests extends TestBase{

    @Test
    public void testButtons() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).
                sendKeys(ConfigReader.getProperty("username"), Keys.TAB,
                        ConfigReader.getProperty("password"), Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnDelete")).isDisplayed());
    }

    @Test (groups = "smoke")
    public void testCheckAll() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys
                (ConfigReader.getProperty("username"), Keys.TAB,
                        ConfigReader.getProperty("password"), Keys.ENTER);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

       List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }

}
