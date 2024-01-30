package prjectdemopackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_cls extends TestBase{
	
	
  @Test(priority = 1)
  public void login_correct_Id_Password() {
	  driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr547531");
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("rYdYjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		
		//Verify welcome massage
		String welcome_msg=driver.findElement(By.xpath("//marquee[@class=\"heading3\"]")).getText();
		boolean validiat_masg=welcome_msg.contains("Welcome To Manager");
		Assert.assertTrue(validiat_masg, "Welcome massge is not displayed");
		
		// Verify manager id
		String manager_id=driver.findElement(By.xpath("//tr[@class=\"heading3\"]")).getText();
		boolean validiat_manager_id=manager_id.contains("mngr547531");
		Assert.assertTrue(validiat_manager_id, "manager Id not matched");
  }
  
  @Test(priority = 2)
  public void login_incorrect_Id_Password() {
	  driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr5531");
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("Yjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		
		Alert a=driver.switchTo().alert();
		String expected_err_msg="User or Password is not valid";
		String actual_err_msg=a.getText();
		Assert.assertEquals(actual_err_msg, expected_err_msg);
		a.accept();
  }
  
  @Test(priority = 3)
  public void login_empty_Id() {
	  
		driver.findElement(By.xpath("//*[@onkeyUp=\"validatepassword();\"]")).sendKeys("Yjah");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		
		Alert a=driver.switchTo().alert();
		String expected_err_msg="User or Password is not valid";
		String actual_err_msg=a.getText();
		Assert.assertEquals(actual_err_msg, expected_err_msg);
		a.accept();
  }
  
  @Test(priority = 4)
  public void login_empty_Password() {
	  
	  driver.findElement(By.xpath("//*[@onkeyUp=\"validateuserid();\"]")).sendKeys("mngr5531");
		driver.findElement(By.xpath("//*[@name=\"btnLogin\"]")).click();
		
		Alert a=driver.switchTo().alert();
		String expected_err_msg="User or Password is not valid";
		String actual_err_msg=a.getText();
		Assert.assertEquals(actual_err_msg, expected_err_msg);
		a.accept();
  }
  
  
}
