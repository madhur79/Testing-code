package G_mail_automation.Unread_mails;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class check_unread_mails {
	//WebDriver driver1= new FirefoxDriver() ;
	Testmails testobj = new Testmails();
	@BeforeClass
	public void launchbrowser()
	{
		testobj.initiateDriver();
	}
	
	@Test(priority=0)
	public void Login()
	{   String usrname = "madhurbhardwaj";
	    String pasword = "Madhur@321#";
	
		String mail_actual = testobj.Login_webmail_test(usrname,pasword);
		Assert.assertEquals(mail_actual,"Mail");
		
	}
	
	
	@Test(priority=1)
	public void unread_mails()
	{
		String extracted_mails= testobj.count_unread_mail_test();
		Assert.assertEquals(extracted_mails,"43");
	}
	
	
	@Test(priority=2)
	public void compose_mail()
	{
		testobj.send_mail_withsubject("madhurbhardwaj@qainfotech.com", "Test Mail");
		testobj.send_mail_withoutsubject("madhurbhardwaj@qainfotech.com", "");
	}
	
	/*@Test(priority=3)
	public void get_translated_text ()
	{
		String g; 
		 g = app.gettext();
		 Assert.assertEquals(g,"hola");
		//System.out.println(g);
		
	}*/
	
	@AfterClass
	public void closebrowser()
	{
		//app.quitdriver();
		//driver1.quit();
	}
	

}
