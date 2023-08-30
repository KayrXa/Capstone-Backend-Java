package test.java.com.project;

import java.text.SimpleDateFormat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyMoviePlanApplicationTests {

	private WebDriver driver;
    @Test
    public void loginPositive() throws InterruptedException {
        driver.get("http://localhost:3000/login/user");
        Thread.sleep(1000);  
        WebElement eleUsername = driver.findElement(By.id("boxUsername"));
        eleUsername.sendKeys("testingAccount");
  	  	Thread.sleep(1000);
  	  	WebElement elePassword = driver.findElement(By.id("boxPassword"));
  	  	elePassword.sendKeys("testing123");
  	  	Thread.sleep(1000);
  	  	WebElement btnLogin = driver.findElement(By.id("btnLogin"));
  	  	btnLogin.click();
  	  	Thread.sleep(1000);
  	  	WebElement eleTitle = driver.findElement(By.id("titMovies"));
  	  	String ActualTitle = eleTitle.getText();
  	  	String ExpectedTitle = "Available Movies";
  	  	Assert.assertEquals(ExpectedTitle, ActualTitle);
    }
    
    @Test
    public void loginNegative() throws InterruptedException {
        driver.get("http://localhost:3000/login/user");
        Thread.sleep(1000);  
        WebElement eleUsername = driver.findElement(By.id("boxUsername"));
        eleUsername.sendKeys("negativeLogin");
  	  	Thread.sleep(1000);
  	  	WebElement elePassword = driver.findElement(By.id("boxPassword"));
  	  	elePassword.sendKeys("negative");
  	  	Thread.sleep(1000);
  	  	WebElement btnLogin = driver.findElement(By.id("btnLogin"));
  	  	btnLogin.click();
  	  	Thread.sleep(1000);
  	  	Alert alert = driver.switchTo().alert();
  	  	String ActualAlert = alert.getText();
  	  	String ExpectedAlert = "Invalid credentials.";
  	  	alert.accept();
  	  	Assert.assertEquals(ExpectedAlert, ActualAlert);
    }
    
    @Test
    public void registerPositive() throws InterruptedException {
        driver.get("http://localhost:3000/login/user");
        Thread.sleep(1000);  
        WebElement eleRegister = driver.findElement(By.id("linkRegister"));
        eleRegister.click();
  	  	Thread.sleep(1000);
  	  	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
  	  	String uniqueName = "name"+timeStamp;
        WebElement eleUsername = driver.findElement(By.id("boxUsername"));
        eleUsername.sendKeys(uniqueName);
  	  	Thread.sleep(1000);
  	  	WebElement eleFname = driver.findElement(By.id("boxFname"));
  	  	eleFname.sendKeys("register");
	  	Thread.sleep(1000);
	  	WebElement eleLname = driver.findElement(By.id("boxLname"));
  	  	eleLname.sendKeys("positive");
  	  	Thread.sleep(1000);
  	  	WebElement eleEmail = driver.findElement(By.id("boxEmail"));
	  	eleEmail.sendKeys("register.positive@gmail.com");
	  	Thread.sleep(1000);
  	  	WebElement elePassword = driver.findElement(By.id("boxPassword"));
  	  	elePassword.sendKeys("negative123");
  	  	Thread.sleep(1000);
  	  	WebElement btnRegister = driver.findElement(By.id("btnRegister"));
  	  	btnRegister.click();
  	  	Thread.sleep(1000);
  	  	WebElement eletitle = driver.findElement(By.id("titLogin"));
  	  	String ActualTitle = eletitle.getText();
  	  	String ExpectedTitle = "Log in to purchase tickets";
  	  	Assert.assertEquals(ExpectedTitle, ActualTitle);
    }
    
    @Test
    public void registerNegative() throws InterruptedException {
    	driver.get("http://localhost:3000/login/user");
        Thread.sleep(1000);  
        WebElement eleRegister = driver.findElement(By.id("linkRegister"));
        eleRegister.click();
  	  	Thread.sleep(1000);
        WebElement eleUsername = driver.findElement(By.id("boxUsername"));
        eleUsername.sendKeys("testingAccount");
  	  	Thread.sleep(1000);
  	  	WebElement eleFname = driver.findElement(By.id("boxFname"));
  	  	eleFname.sendKeys("Fname");
	  	Thread.sleep(1000);
	  	WebElement eleLname = driver.findElement(By.id("boxLname"));
  	  	eleLname.sendKeys("Lname");
  	  	Thread.sleep(1000);
  	  	WebElement eleEmail = driver.findElement(By.id("boxEmail"));
	  	eleEmail.sendKeys("email@gmail.com");
	  	Thread.sleep(1000);
  	  	WebElement elePassword = driver.findElement(By.id("boxPassword"));
  	  	elePassword.sendKeys("password");
  	  	Thread.sleep(1000);
  	  	WebElement btnRegister = driver.findElement(By.id("btnRegister"));
  	  	btnRegister.click();
  	  	Thread.sleep(1000);
  	  	Alert alert = driver.switchTo().alert();
	  	String ActualAlert = alert.getText();
	  	String ExpectedAlert = "Registration unsuccessful. Try different username.";
	  	alert.accept();
	  	Assert.assertEquals(ExpectedAlert, ActualAlert);
    }
    
    @BeforeMethod
    public void beforeMethod() {
       
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
    	Thread.sleep(5000);
    }
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public void afterClass() {
    	if (driver != null) {
            driver.quit();
        }
    }

}