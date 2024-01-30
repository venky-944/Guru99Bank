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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Customer_cls extends TestBase {
	
	
	@BeforeMethod
	
	public void login() {
		
		driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr547531");
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("rYdYjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		
		
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("befor Test");
	}
	
	@AfterTest
	public void af() {
		System.out.println("after Test");
	}
	
	@Test(priority = 1)
	public void addCustomer_validDetails() throws IOException, InterruptedException {
		
		driver.findElement(By.xpath("//*[text()=\"New Customer\"]")).click();
		
		
//		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		 mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"heading3\"]")));
//		 
//	
//		//Verify Title Of page
//		String expected_title="Guru99 Bank New Customer Entry Page";
//		String actual_title=driver.findElement(By.tagName("title")).getText();
//		System.out.println(actual_title);
//		//Assert.assertEquals(actual_title, expected_title, "Title not matched");
		
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatecustomername();\"]")).sendKeys("ramesh");
		driver.findElement(By.xpath("//input[@value=\"m\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"dob\"]")).sendKeys("15/09/1999");
		driver.findElement(By.xpath("//textarea[contains(@name,\"addr\")]")).sendKeys("541 Guntur Andhra Pradesh");
		driver.findElement(By.xpath("//input[contains(@name,\"city\")]")).sendKeys("Guntur");
		driver.findElement(By.xpath("//input[contains(@name,\"state\")]")).sendKeys("Andhra Pradesh");
		driver.findElement(By.xpath("//input[contains(@name,\"pinno\")]")).sendKeys("522658");
		driver.findElement(By.xpath("//input[contains(@name,\"telephoneno\")]")).sendKeys("9537251387");
		driver.findElement(By.xpath("//input[contains(@name,\"emailid\")]")).sendKeys("ramesh245@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,\"password\")]")).sendKeys("Rame@8787");
		driver.findElement(By.xpath("//input[contains(@type,\"submit\")]")).click();
		//if user existe handel the alert
			try {
				Alert a=driver.switchTo().alert();
				a.accept();
			}catch(NoAlertPresentException e){
				
				TakesScreenshot home=(TakesScreenshot)driver;
				File src=home.getScreenshotAs(OutputType.FILE);
				File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\customerregesterd.png");
				FileUtils.copyFile(src, trg);
				String cusId=driver.findElement(By.xpath("//*[@id=\"customer\"]//tr[4]//td[2]")).getText();
				
			}
			
			
	}
		
		@Test
		(priority = 2)
		public void empty_Details() {
			Actions act=new Actions(driver);
			
			driver.findElement(By.xpath("//*[text()=\"New Customer\"]")).click();
			
			act.click(driver.findElement(By.xpath("//*[@onkeyUp=\"validatecustomername();\"]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[@id=\"dob\"]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//textarea[contains(@name,\"addr\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"city\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"state\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"pinno\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"telephoneno\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"emailid\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			act.click(driver.findElement(By.xpath("//input[contains(@name,\"password\")]"))).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB);
			
			TakesScreenshot home=(TakesScreenshot)driver;
			File src=home.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\blankfieldErrormsgs.png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//input[contains(@type,\"submit\")]")).click();
			Alert a=driver.switchTo().alert();
			System.out.println(a.getText());
			a.accept();
		}
			
		
		@Test
		(priority = 3)
		public void enter_invalid_details() {
			
			driver.findElement(By.xpath("//*[text()=\"New Customer\"]")).click();
			
			driver.findElement(By.xpath("//*[@onkeyUp=\"validatecustomername();\"]")).sendKeys("ramesh25");
			
			driver.findElement(By.xpath("//input[@id=\"dob\"]")).sendKeys("15/09/199h");
			
			driver.findElement(By.xpath("//textarea[contains(@name,\"addr\")]")).sendKeys("541,Guntur Andhra Pradesh");
			
			driver.findElement(By.xpath("//input[contains(@name,\"city\")]")).sendKeys("Guntur25");
			
			driver.findElement(By.xpath("//input[contains(@name,\"state\")]")).sendKeys("Andhra Pradesh97");
			
			driver.findElement(By.xpath("//input[contains(@name,\"pinno\")]")).sendKeys("522vn");
			
			driver.findElement(By.xpath("//input[contains(@name,\"telephoneno\")]")).sendKeys("953725138jkl");
			
			driver.findElement(By.xpath("//input[contains(@name,\"emailid\")]")).sendKeys("ramesh874422@");
			
			driver.findElement(By.xpath("//input[contains(@name,\"password\")]")).sendKeys("Ram@8787");
			
			TakesScreenshot home=(TakesScreenshot)driver;
			File src=home.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\invalidfielderrormsgs.png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		@Test
		(priority = 4)
		public void edit_customer_with_validuserId() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.xpath("//*[text()=\"Edit Customer\"]")).click();
			Thread.sleep(3);
			//driver.navigate().refresh();
			
//			// Verify Title of the page
//			String expected_title="Guru99 Bank Edit Customer Entry Page";
//			String actualtitle=driver.getTitle();
//			Assert.assertEquals(actualtitle, expected_title, "Edit customer page not open");
			
			
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("60888");
			driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
			
			// Edit mobile number of customer
			driver.findElement(By.xpath("//input[contains(@name,\"telephoneno\")]")).sendKeys("953725138");
			
			driver.findElement(By.xpath("//input[contains(@type,\"submit\")]")).click();
			
			Alert a=driver.switchTo().alert();
			String expected_text="Changes are made to Customer record";
			String actual_text=a.getText();
			Assert.assertEquals(actual_text, expected_text);
			a.accept();
		}
		
		@Test
		(priority = 5)
		public void edit_customer_with_invaliduserId() {
			
			driver.findElement(By.xpath("//*[text()=\"Edit Customer\"]")).click();
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("84568");
			driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
			
			Alert a=driver.switchTo().alert();
			String expected_text="Customer does not exist!!";
			String actual_text=a.getText();
			Assert.assertEquals(expected_text, actual_text);
			a.accept();
		}
		
		@Test
		(priority = 6)
		public void edit_customer_with_emptyuserId() {
			Actions act=new Actions(driver);
			driver.findElement(By.xpath("//*[text()=\"Edit Customer\"]")).click();
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("");
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			TakesScreenshot home=(TakesScreenshot)driver;
			File src=home.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\editcustomer.cusIdrequierrmsg.png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		@Test
		(priority = 7)
		public void delet_customer_vailid_cusId() throws InterruptedException {
			driver.findElement(By.xpath("//*[text()=\"Delete Customer\"]")).click();
			
			String expected_title="Guru99 Bank Delete Customer Page";
			String actual_title=driver.getTitle();
			Assert.assertEquals(actual_title, expected_title);
			
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("920");
			driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
			
			driver.switchTo().alert().accept();
			
			Thread.sleep(3);
			
			Alert a=driver.switchTo().alert();
			String expected_test="Customer deleted successfully";
			String actual_text=a.getText();
			a.accept();
			Assert.assertEquals(actual_text, expected_test);
				
		}
		
		@Test
		(priority = 8)
		public void delet_customer_invailid_cusId() throws InterruptedException {
			driver.findElement(By.xpath("//*[text()=\"Delete Customer\"]")).click();
			
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("12345");
			driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
			
			
			driver.switchTo().alert().accept();
			Thread.sleep(3);
			
			String expected_test="Customer does not exist!!";
			Alert a=driver.switchTo().alert();
			String actual_text=a.getText();
			a.accept();
			
			Assert.assertEquals(actual_text, expected_test);
			
		}
		
		@Test
		(priority = 9)
		public void delet_customer_blank_cusId() {
			driver.findElement(By.xpath("//*[text()=\"Delete Customer\"]")).click();
			
			driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("");
			Actions act=new Actions(driver);
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			TakesScreenshot home=(TakesScreenshot)driver;
			File src=home.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\deletcustomer.cusIdrequierrmsg.png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
				
			
		
		
		
		
		

	
}
