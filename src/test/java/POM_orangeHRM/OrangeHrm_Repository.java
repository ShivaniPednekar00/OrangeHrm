package POM_orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrm_Repository {
	WebDriver driver;
	public OrangeHrm_Repository(WebDriver wd)
	{
		driver =wd;
		PageFactory.initElements(driver, this);

	}
	//REPOSITORY
	@FindBy(name="username")WebElement UserName;
	@FindBy(name="password")WebElement Password;
	@FindBy(xpath="//button[@type='submit']")WebElement login;
	
	@FindBy(xpath="//div[@class='oxd-topbar-header-title']/child::span/child::h6") WebElement dash;
	
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")WebElement ErrorMsg;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")WebElement req;
	//@FindBy(xpath="//ul[@class='oxd-main-menu']/child::li/child::a[text()='My Info']") WebElement myinfo;
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']/child::ul/child::li/descendant::span[text()='My Info']") WebElement myinfo;
	@FindBy(xpath="//div[@class='orangehrm-tabs']/child::div[4]/child::a") WebElement dependents;
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/div/div/button/i")WebElement AssignBtn;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::input[1]") WebElement Name;
	@FindBy(xpath="//div[@class='oxd-date-wrapper']/child::div/child::input") WebElement dob;
	@FindBy(xpath="//div[@class='oxd-select-text-input']") WebElement SelectRelation;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[2]") WebElement Depsavebtn;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") WebElement err;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[1]") WebElement Cancel;
	
	
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/child::div[3]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]") WebElement DeleteSym;
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/child::div[2]/child::div[1]/child::div[1]/child::button") WebElement DependCheckbox;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/child::button[2]")WebElement DepPopup;
	
	@FindBy(xpath="//div[@class='orangehrm-attachment']/div/div/button/i") WebElement attachBtn;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::input") WebElement file;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::textarea") WebElement comment;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[2]") WebElement AssisnSaveBtn;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") WebElement Error;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[1]")WebElement CancelAttach;
	
	@FindBy(xpath="//div[@class='orangehrm-attachment']/child::div[3]/child::div/child::div/child::div/child::div/child::div") WebElement AssignCheckbx;
	@FindBy(xpath="//div[@class='orangehrm-attachment']/child::div[2]/child::div[1]/child::div[1]/child::button")WebElement DeltBtn;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/child::button[2]")WebElement DeltPopUp;
	
	
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/child::div/child::h6")WebElement personal;
	
}
