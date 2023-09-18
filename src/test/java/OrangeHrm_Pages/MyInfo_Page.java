package OrangeHrm_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo_Page {
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/child::ul/child::li/descendant::span[text()='My Info']")public WebElement myinfo;
	@FindBy(xpath="//div[@class='orangehrm-tabs']/child::div[4]/child::a")public WebElement dependents;
	
	WebDriver driver;
	public MyInfo_Page(WebDriver wd)
	{
		driver =wd;
		PageFactory.initElements(driver, this);

	}
	public void myinfoClick()
	{
		myinfo.click();
	}
	public void dependentsClick()
	{
		dependents.click();
	}
	

}
