package OrangeHrm_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignedDependent_Page {
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/div/div/button/i")public WebElement AssignBtn;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::input[1]")public WebElement Name;
	@FindBy(xpath="//div[@class='oxd-date-wrapper']/child::div/child::input")public WebElement dob;
	@FindBy(xpath="//div[@class='oxd-select-text-input']")public WebElement SelectRelation;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[2]")public WebElement Depsavebtn;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")public WebElement err;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[1]")public WebElement Cancel;
	
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/child::div[3]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]")public WebElement DeleteSym;
	@FindBy(xpath="//div[@class='orangehrm-edit-employee-content']/child::div[2]/child::div[1]/child::div[1]/child::button")public WebElement DependCheckbox;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/child::button[2]")public WebElement DepPopup;
	WebDriver driver;
	public AssignedDependent_Page(WebDriver wd)
	{
		driver =wd;
		PageFactory.initElements(driver, this);

	}
	public void AssignDependentClick()
	{
		AssignBtn.click();
	}
	public void name(String name)
	{
		Name.sendKeys(name);
	}
	public void dateOfBirth()
	{
		dob.sendKeys("2022-06-07");
	}
	public void Relationship()
	{
		SelectRelation.click();
		Actions act=new Actions(driver);
	    act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
	}
	public void savebtnClick()
	{
		Depsavebtn.click();
	}
	public String VerifyRequired()
	{
		return err.getText();
	}
	public void cancelClick()
	{
		Cancel.click();
	}
	public void oneCred()
	{
		Name.click();
		Actions act=new Actions(driver);
    	act.sendKeys(Keys.NUMPAD2).build().perform();
    	
	}
	public void deletecheck()
	{
		DeleteSym.click();
		
	}
	public void an()
	{
		DependCheckbox.click();
	}
	public void ac()
	{
		DepPopup.click();
	}
	public void pgup()
	{
		Actions k=new Actions(driver);
    	k.sendKeys(Keys.PAGE_UP).build().perform();
	}

}
