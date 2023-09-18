package OrangeHrm_Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_Page {
	@FindBy(xpath="//input[@placeholder='Username']")public  WebElement UserName;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement Password;
	@FindBy(xpath="//button[@type='submit']")WebElement login;
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")WebElement ErrorMsg;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")WebElement req;
	
	WebDriver driver;
	public Login_Page(WebDriver wd)
	{
		driver =wd;
		PageFactory.initElements(driver, this);

	}
	public void ussername(String userName) throws IOException
	{
		UserName.sendKeys(userName);
	}
	public void password(String password) throws IOException
	{
		Password.sendKeys(password);
	}
	public void loginbtn()
	{
		login.click();
		
	}
	public String VerifyInvalid()
	{
		return ErrorMsg.getText();

	}
	public String VerifyRequired()
	{
		return req.getText();
	}

}
