package prjectdemopackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Customer_cls2{
	
	
//	@BeforeTest
//	public void bt() {
//		System.out.println("befor Test");
//	}
//	
//	@AfterTest
//	public void af() {
//		System.out.println("after Test");
//	}
//	
//	@Test
//	@Parameters("browser")
//	public void f(String browsername) {
//		System.out.println("test ");
//		System.out.println("getting value from xml file::"+browsername);
//	}
//		
//	@Test
//	@Parameters("city")
//	public void balu(String cityname) {
//		System.out.println("test ");
//		System.out.println("getting value from xml file::"+cityname);
//	}
	
	
	
	
	@Test(dataProvider = "loginTestData")
	public void browser(String user,String pass) {
	
		WebDriver driver;
		  driver=new FirefoxDriver();
		  driver.get("https://www.demo.guru99.com/V4/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys(user);
		  driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys(pass);
		  driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
	}
				
			
	@DataProvider(name="loginTestData")
	public Object[][] logindata(){
		  
		Object[][] data= new Object[3][2];
		
		data[0][0]="mngr547531";
		data[0][1]="rYdYjah";
		
		data[1][0]="mngr547531";
		data[1][1]="Venky@0";
		
		data[2][0]="mngr5431";
		data[2][1]="rYdYjah";
		
		
		return data;
		
		
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		

	
}
