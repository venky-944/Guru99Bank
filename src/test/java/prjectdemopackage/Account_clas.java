package prjectdemopackage;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class Account_clas extends TestBase{
	
	
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr547531");
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("rYdYjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
  }
  
  
  @Test(priority = 1)
  public void newAccount_validDetails() throws IOException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[text()=\"New Account\"]")).click();
		
//		// Verify the title of the page
//		String expected_title="Guru99 bank add new account";
//		String actual_title=driver.getTitle();
//		Assert.assertEquals(actual_title, expected_title);
		
		//Enter cusId
		driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("78820");
		
		// Select account type
		WebElement sel_acount_el=driver.findElement(By.xpath("//*[@name=\"selaccount\"]"));
		Select sec_account=new Select( sel_acount_el);
		sec_account.selectByValue("Savings");
		
		// Enter initial deposit amount and submit
		driver.findElement(By.xpath("//*[@name=\"inideposit\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@value=\"submit\"]")).click();
		
		//if user existe handel the alert
		try {
			Alert a=driver.switchTo().alert();
			a.accept();
		}catch(NoAlertPresentException e){
			
			TakesScreenshot home=(TakesScreenshot)driver;
			File src=home.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\accountcreated.png");
			FileUtils.copyFile(src, trg);
			
			
			
			
		}
		
		}
  
  @Test(priority = 2)
  public void newAccount_invalidDetails() {
		driver.findElement(By.xpath("//*[text()=\"New Account\"]")).click();
		
		//Enter cusId
		driver.findElement(By.xpath("//*[@name=\"cusid\"]")).sendKeys("123456");
		
		// Select account type
		WebElement sel_acount_el=driver.findElement(By.xpath("//*[@name=\"selaccount\"]"));
		Select sec_account=new Select( sel_acount_el);
		sec_account.selectByValue("Savings");
		
		// Enter initial deposit amount and submit
		driver.findElement(By.xpath("//*[@name=\"inideposit\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@value=\"submit\"]")).click();
		
		Alert a=driver.switchTo().alert();
		
		String expected_msg="Customer does not exist!!";
		String actual_msg=a.getText();
		a.accept();
		Assert.assertEquals(actual_msg, expected_msg);
		
		
		}
  
  @Test(priority = 3)
  public void newAccount_emptyDetails() {
	  Actions act=new Actions(driver);
		driver.findElement(By.xpath("//*[text()=\"New Account\"]")).click();
		
		//Enter cusId
		driver.findElement(By.xpath("//*[@name=\"cusid\"]")).click();
		
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// Enter initial deposit amount and submit
		driver.findElement(By.xpath("//*[@name=\"inideposit\"]")).click();
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		driver.findElement(By.xpath("//*[@value=\"submit\"]")).click();
		
		Alert a=driver.switchTo().alert();
		
		String expected_msg="Please fill all fields";
		String actual_msg=a.getText();
		a.accept();
		Assert.assertEquals(actual_msg, expected_msg);
		
		TakesScreenshot home=(TakesScreenshot)driver;
		File src=home.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\newAccountrequirddetalis.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
  
  
  @Test(priority = 4)
  public void editAccount_validId() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Edit Account\"]")).click();

//	  // Verify the title of the page
//	  String expected_title="Guru99 bank add new account";
//	  String actual_title=driver.getTitle();
//	  Assert.assertEquals(actual_title, expected_title);


	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("131288");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
  }
  
  @Test(priority = 5)
  public void editAccount_invalidId() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Edit Account\"]")).click();


	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("131255");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
	  Alert a=driver.switchTo().alert();
	  a.accept();
  }
  
  @Test(priority = 6)
  public void editAccount_emptyId() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Edit Account\"]")).click();
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).click();
	  
	  act.keyDown(Keys.TAB).keyUp(Keys.DOWN).perform();
	  
	  TakesScreenshot home=(TakesScreenshot)driver;
		File src=home.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\EditaccountUserIdrequird.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
  }
  
  
  @Test(priority = 7)
  public void deletAccount_correctUserId() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[text()=\"Delete Account\"]")).click();
	  
	  // Verify the title of the page
	  String expected_title="Guru99 Bank Delete Account Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("131155");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();

	  driver.switchTo().alert().accept();
	  
	  Thread.sleep(3);
	  
	  Alert a=driver.switchTo().alert();
	  String expected_text="Cutomer deleted successfully!";
	  String actual_text=a.getText();
	  Assert.assertEquals(actual_text, expected_text);
	  a.accept();
	  
	  
	  
  }
  
  
  @Test(priority = 8)
  public void deletAccount_incorrectUserId() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[text()=\"Delete Account\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("123545");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();

	  driver.switchTo().alert().accept();
	  
	  Thread.sleep(3);
	  
	  Alert a=driver.switchTo().alert();
	  String expected_text="Cutomer does not exist!!";
	  String actual_text=a.getText();
	  Assert.assertEquals(actual_text, expected_text);
	  a.accept(); 
	  
  }
  
  

  @Test(priority = 9)
  public void deletAccount_emptyUserId() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[text()=\"Delete Account\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).click();

	  act.keyDown(Keys.TAB).keyUp(Keys.DOWN).perform();
	  
	  TakesScreenshot home=(TakesScreenshot)driver;
		File src=home.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\venky\\Desktop\\Guru99 Bank Screenshots\\DeletaccountUserIdrequird.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
