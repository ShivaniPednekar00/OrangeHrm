package POM_orangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prac {
	OrangeHrm_Repository re;
	WebDriver driver;
	@BeforeSuite
	public void ora() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		
	}
	@Test
	public void hh() throws InterruptedException
	{
//LOGIN		
		re=new OrangeHrm_Repository(driver);
		re.UserName.sendKeys("Admin");
		re.Password.sendKeys("admin123");
		re.login.click();
		//String a=re.dash.toString();
		//String a=driver.getTitle();
//				
//		Assert.assertEquals(a,"Dashboard");
//		System.out.println("login susscessful");
		Thread.sleep(2000);
		
		
//MYINFO
		re.myinfo.click();
//		String n=re.personal.getText();
//		Assert.assertEquals(n,"Personal Details");
		Thread.sleep(3000);
//DEPENDENTS		
		re.dependents.click();
		Thread.sleep(3000);
//ASSIGNED DEPENDENTS
		re.AssignBtn.click();
		Thread.sleep(3000);
		re.Name.sendKeys("asdf");
		re.dob.sendKeys("2023-06-15");
		re.SelectRelation.click();
		Actions act=new Actions(driver);
		
		
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		re.Depsavebtn.click();
		Thread.sleep(4000);
		

		
//ADD ATTACHMENT
		re.attachBtn.click();
		Thread.sleep(3000);
		re.file.sendKeys("C:\\Users\\admin\\Desktop\\TestData.xlsx");
		re.comment.sendKeys("hello");
		re.AssisnSaveBtn.click();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		
		
//DELETE DEPENDENTS		
				re.DeleteSym.click();
				re.DependCheckbox.click();
				re.DepPopup.click();
				Thread.sleep(3000);		
				
//DELETE ASSIGN
				
				re.AssignCheckbx.click();
				re.DeltBtn.click();
				re.DeltPopUp.click();
				
	}
	
}
