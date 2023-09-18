package OrangeHrm_Pages;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM_orangeHRM.OrangeHrm_Repository;

public class Attachment_page {
	@FindBy(xpath="//div[@class='orangehrm-attachment']/div/div/button/i")public WebElement attachBtn;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::input")public WebElement File;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']/child::div[2]/child::textarea")public WebElement Comment;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[2]")public WebElement AssisnSaveBtn;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")public WebElement Error;
	@FindBy(xpath="//div[@class='oxd-form-actions']/child::button[1]")public WebElement CancelAttach;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")public WebElement err;
	
	@FindBy(xpath="//div[@class='orangehrm-attachment']/child::div[3]/child::div/child::div/child::div/child::div/child::div")public WebElement AssignCheckbx;
	@FindBy(xpath="//div[@class='orangehrm-attachment']/child::div[2]/child::div[1]/child::div[1]/child::button")public WebElement DeltBtn;
	@FindBy(xpath="//div[@class='orangehrm-modal-footer']/child::button[2]")public WebElement DeltPopUp;
	
	WebDriver driver;
	public Attachment_page(WebDriver wd)
	{
		driver =wd;
		PageFactory.initElements(driver, this);

	}
	public void clickOnAdd()
	{
		attachBtn.click();
	}
	public void file(String file)
	{
		File.sendKeys(file);
	}
	public void comment(String comment)
	{
		Comment.sendKeys(comment);
	}
	public void saveBtn()
	{
		AssisnSaveBtn.click();
	}
	public String verifyRequired()
	{
		return err.getText();
	}
	public void cancelClick()
	{
		CancelAttach.click();
	}
	public void checkbox()
	{
		AssignCheckbx.click();
	}
	public void cc()
	{
		DeltBtn.click();
	}
	public void dd()
	{
		DeltPopUp.click();
	}
}
