package prjectdemopackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User_Actions_cls extends TestBase {
	
	
	@BeforeMethod
	public void login() {
		
		driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr547531");
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("rYdYjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
	}
	
  @Test(priority = 1)
  public void amount_Deposit_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Deposit\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Amount Deposit Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  
	  driver.findElement(By.xpath("input[name=\"accountno\"]")).sendKeys("131155");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("1000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount deposit");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  
  }
  
  @Test(priority = 2)
  public void amount_Deposit_invalidAccountNo() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Deposit\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Amount Deposit Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  
	  driver.findElement(By.xpath("input[name=\"accountno\"]")).sendKeys("15155");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("10000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount deposit");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  driver.switchTo().alert().accept();  
	  
  }
  
  @Test(priority = 3)
  public void amount_Withdraw_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Withdrawal\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Amount Withdrawal Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  
	  driver.findElement(By.xpath("input[name=\"accountno\"]")).sendKeys("131155");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("10000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount deposit");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  
  }
  
  @Test(priority = 4)
  public void amount_Withdraw_invalidAccountNo() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Withdrawal\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Amount Withdrawal Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  
	  driver.findElement(By.xpath("input[name=\"accountno\"]")).sendKeys("13589");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("5000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount withdraw");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  driver.switchTo().alert().accept();
	  
  }
  
  @Test(priority = 5)
  public void amount_Transfer_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Fund Transfer\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Fund Transfer Entry Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  
	  driver.findElement(By.xpath("input[name=\"payersaccount\"]")).sendKeys("131155");
	  driver.findElement(By.xpath("input[name=\"payeeaccount\"]")).sendKeys("17895");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("4000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount transfer..");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  
  }
  
  @Test(priority = 6)
  public void amount_Transfer_invalidDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Fund Transfer\"]")).click();
	  
	  //Verify title of the page
	  String expected_title="Guru99 Bank Fund Transfer Entry Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  driver.findElement(By.xpath("input[name=\"payersaccount\"]")).sendKeys("131478");
	  driver.findElement(By.xpath("input[name=\"payeeaccount\"]")).sendKeys("17895");
	  driver.findElement(By.xpath("input[name=\"ammount\"]")).sendKeys("4000");
	  driver.findElement(By.xpath("input[name=\"desc\"]")).sendKeys("amount transfer..");
	  driver.findElement(By.xpath("input[name=\"AccSubmit\"]")).click();
	  
	  
  }
  
  
  @Test(priority = 7)
  public void changepassword_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Change Password\"]")).click();
	  
	//Verify title of the page
	  String expected_title="Guru99 Bank Change Password Page";
	  String actual_title=driver.getTitle();
	  Assert.assertEquals(actual_title, expected_title, "Title not matched");
	  
	  driver.findElement(By.xpath("input[name=\"oldpassword\"]")).sendKeys("rYdYjah");
	  driver.findElement(By.xpath("input[name=\"newpassword\"]")).sendKeys("Venky@123");
	  driver.findElement(By.xpath("input[name=\"confirmpassword\"]")).sendKeys("Venky@123");
	  
	  driver.findElement(By.xpath("input[name=\"sub\"]")).click();
	  
	  
  }
  
  @Test(priority = 8)
  public void changepassword_invalidDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Change Password\"]")).click();
	  
	  driver.findElement(By.xpath("input[name=\"oldpassword\"]")).sendKeys("5151v");
	  driver.findElement(By.xpath("input[name=\"newpassword\"]")).sendKeys("Venky@123");
	  driver.findElement(By.xpath("input[name=\"confirmpassword\"]")).sendKeys("Venky@123");
	  
	  driver.findElement(By.xpath("input[name=\"sub\"]")).click();
	  
	  driver.switchTo().alert().accept();
	  
	  
  }
  
  @Test(priority = 9)
  public void balanceEnquire_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Balance Enquiry\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("25454");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
  }
  
  @Test(priority = 10)
  public void balanceEnquire_invalidDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Balance Enquiry\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
	  driver.switchTo().alert().accept();
	  
  }
  
  @Test(priority = 11)
  public void miniStatment_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Mini Statement\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
  }
  
  @Test(priority = 12)
  public void miniStatment_invalidDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Mini Statement\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
	  driver.switchTo().alert().accept();
  }
  
  @Test(priority = 13)
  public void customizeStatment_validDetails() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Customised Statement\"]")).click();
	  
	  driver.findElement(By.xpath("//*[@name=\"accountno\"]")).sendKeys("12345");
	  driver.findElement(By.xpath("//*[@name=\"fdate\"]")).sendKeys("17/01/2024");
	  driver.findElement(By.xpath("//*[@name=\"tdate\"]")).sendKeys("17/02/2024");
	  driver.findElement(By.xpath("//*[@name=\"amountlowerlimit\"]")).sendKeys("100");
	  driver.findElement(By.xpath("//*[@name=\"numtransaction\"]")).sendKeys("15");
	  driver.findElement(By.xpath("//*[@name=\"AccSubmit\"]")).click();
	  
	  driver.switchTo().alert().accept();
  }
  
  @Test(priority = 14)
  public void logout() {
	  
	  driver.findElement(By.xpath("//*[text()=\"Log out\"]")).click();
	  
	 driver.switchTo().alert().accept();
  }
  
 
}
