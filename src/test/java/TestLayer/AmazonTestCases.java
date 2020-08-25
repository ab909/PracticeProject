package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTestCases {
	
	static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhib\\Desktop\\chromedriver_win32 (7)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/");
	}
	
	@Test
	public void amazonTitleTest() {
		String title= driver.getTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	
	@Test
	public void signInTest() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.cssSelector(".nav-action-inner")).click();
		driver.findElement(By.id("ap_email")).sendKeys("abhi.bhatt100@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("hiltonhotels");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amazon.ca/?ref_=nav_signin&");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}

