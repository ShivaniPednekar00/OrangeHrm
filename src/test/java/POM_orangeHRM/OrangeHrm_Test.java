package POM_orangeHRM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class OrangeHrm_Test {

	WebDriver driver;
	
	login_page log;
	
	
	@Test()
	public void validate_login() throws InterruptedException, IOException
	{
		
		log=new login_page();
		
		log.launchBrowser();
		log.InValidcred();
		log.blankCred();
		log.OneBlankcred();
		log.validCred();
		Thread.sleep(3000);
		log.click_onMyInfo();
		log.Click_onDependents();
		log.Add_AssignedDep();
		log.AddValidDependents();
		Thread.sleep(3000);
		log.Add_AssignedDep();
		log.blankDependents();
		log.Validate_cancel();
		Thread.sleep(3000);
		log.Add_AssignedDep();
		log.oneCred();
		log.Add_Attachment();
		log.Attach_Valid();
		
		log.Add_Attachment();
		log.Attach_blank();
		log.AttachCancelBtn();
		log.DeleteAss();
	    log.deleteAttac();
	    log.quit();

	}
	
	



}
