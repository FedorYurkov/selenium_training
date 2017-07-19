package ru.stqa.training.selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginToAdminPanelTest {
  private WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void testLoginToAdminPanel() {
    driver.get("http://localhost/litecart/admin/login.php/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    //driver.findElement(By.name("login")).click();
    driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
  }

  @After
  public  void stop() {
    driver.quit();
    driver = null;
  }
}
