package prjectdemopackage;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestBase {
	
 public  WebDriver driver;
 public Actions act;
 
  
 
@Test
public void f() {
	System.out.println("venky");
}
  
//  @BeforeMethod
//  @Parameters("browser")
//  public void browserintailtion(String br) {
//	  
//	  if (br.equalsIgnoreCase("chrome")) {
//		  driver=new ChromeDriver();
//	  }else if(br.equalsIgnoreCase("edge")) {
//		  driver=new EdgeDriver();
//	  }else if(br.equalsIgnoreCase("firfox")) {
//		  driver=new FirefoxDriver();
//	  }
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	  driver.get("https://www.demo.guru99.com/V4/");
//	  
//	  
//  }
  
//  @BeforeMethod
//  public void browser() {
//	  
//	  driver=new ChromeDriver();
//	  driver.get("https://www.demo.guru99.com/V4/");
//	  act=new Actions(driver);
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	 
//  }
  
  @BeforeMethod
public void browser() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.demo.guru99.com/V4/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
  

//  @AfterMethod
//  public void afterMethod() {
//	  driver.quit();
//	  
//	  
//  }

}
