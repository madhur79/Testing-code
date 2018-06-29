package G_mail_automation.Unread_mails;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class Testmails
{
	WebDriver driver = new FirefoxDriver();
	//Testmails testobj2 =new Testmails();
	public void initiateDriver()
	{
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver.get("https://webmail.qainfotech.com:8443");
	}
	public String Login_webmail_test(String usernme , String passwrd)
	{
		WebElement loginbox = driver.findElement(By.id("username"));
		loginbox.sendKeys(usernme);	
		WebElement passwordbox = driver.findElement(By.id("password"));
		passwordbox.sendKeys(passwrd);
		
		WebElement sigin_button = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]"));
		 sigin_button.click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement obj = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"zb__App__Mail_title\"]")));
			String mail_actual = obj.getText();
			driver.findElement(By.xpath("//*[@id=\"zb__App__Contacts_title\"]")).click();
			
			
			return mail_actual;
			}
	public String count_unread_mail_test()
	{
		WebElement inbox = driver.findElement(By.xpath("/html/body/div[3]/div[24]/div[6]/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[3]/span"));
		String mails=inbox.getText();
		String extracted_mails = mails.substring(7,9);
		return extracted_mails;
	}
	public void send_mail_withsubject(String emailid,String mail_subject )
	{
		WebElement new_message = driver.findElement(By.xpath("//*[@id=\"zb__NEW_MENU_title\"]"));
		new_message.click();
		WebElement receiver_email_id = driver.findElement(By.id("zv__COMPOSE-1_to_control"));
		receiver_email_id.sendKeys(emailid);
		WebElement subject = driver.findElement(By.id("zv__COMPOSE-1_subject_control"));
		subject.sendKeys(mail_subject);
		driver.switchTo().frame("ZmHtmlEditor1_body_ifr");
		WebElement text = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
		text.sendKeys("Do not panic,this is a system generated mail...Do not reply");
		driver.switchTo().defaultContent();
		WebElement send_button = driver.findElement(By.id("zb__COMPOSE-1__SEND_title"));
		send_button.click();
		
		
	}
	
	public void send_mail_withoutsubject(String emailid,String mail_subject )
	{ 
		try {
		Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			
		}
		
		send_mail_withsubject("madhurbhardwaj@qainfotech.com","" );
		try {
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				
			}
		WebElement ok_button = driver.findElement(By.id("OkCancel_button2_title"));
		ok_button.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();	
		
		
	}
	
}
