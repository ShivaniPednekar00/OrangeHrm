package POM_orangeHRM;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import POM_orangeHRM.OrangeHrm_Repository;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login_pagesss {
	
	OrangeHrm_Repository obj;
	WebDriver driver;
	
	@BeforeSuite
	public void launchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		obj=new OrangeHrm_Repository(driver);
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void InValidcred() throws IOException, InterruptedException
	{
		String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows =sheet.getLastRowNum();
		System.out.println("number of rows:" +rows);
		for(int r=1;r<=3;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell userName=row.getCell(0);
			XSSFCell password=row.getCell(1);
			System.out.println("usserName:-->"+userName+ "password:-->"+password);
			obj=new OrangeHrm_Repository(driver);
			obj.UserName.sendKeys(userName.toString());
			obj.Password.sendKeys(password.toString());
			obj.login.click();
			Thread.sleep(2000);
			
			String a=obj.ErrorMsg.getText();
			
				Assert.assertEquals(a,"Invalid credentials");
				
		}
		
	}
	
	@Test(priority=2)
	public void blankCred() throws IOException
	{
		obj.login.click();
		String b=obj.req.getText();
		Assert.assertEquals(b,"Required");
		
	}


@Test(priority=3)
public void OneBlankcred() throws IOException, InterruptedException
{
	obj.UserName.click();
	Actions act=new Actions(driver);
	act.sendKeys(Keys.NUMPAD2).build().perform();
	obj.login.click();
	String c=obj.req.getText();
	Assert.assertEquals(c,"Required");
	System.out.println("one cred is empty");
	act.click(obj.UserName).sendKeys(Keys.BACK_SPACE).build().perform();
		
	
}

	

    @Test(priority=4)
	public void validCred() throws IOException, InterruptedException
	{
	
		String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows =sheet.getLastRowNum();
		System.out.println("number of rows:" +rows);
		
		for(int r=4;r<=4;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell userName=row.getCell(0);
			XSSFCell password=row.getCell(1);
			System.out.println("usserName:-->"+userName+ "password:-->"+password);
			obj=new OrangeHrm_Repository(driver);
			obj.UserName.sendKeys(userName.toString());
			obj.Password.sendKeys(password.toString());
			obj.login.click();
//			String act=obj.dash.getText();
//			Assert.assertEquals(act,"Dashboard");
//			System.out.println("login successful");
			Thread.sleep(3000);

			
			
		}
	}
    @Test(priority=5)
	public void click_onMyInfo() throws InterruptedException
	{
	    obj=new OrangeHrm_Repository(driver);
        obj.myinfo.click();	
        Thread.sleep(3000);
		
	}
    
    @Test(priority=6)
    public void Click_onDependents() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.dependents.click();
    	Thread.sleep(3000);
    }
    
    @Test(priority=7)
    public void Add_AssignedDep() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.AssignBtn.click();
    	Thread.sleep(3000);

    }
    
    @Test(priority=8)
    public void AddValidDependents() throws IOException, InterruptedException
    {
    	
    	
    	obj=new OrangeHrm_Repository(driver);
    	
    	String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows =sheet.getLastRowNum();
		System.out.println("number of rows:" +rows);
		for(int r=1;r<=1;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell name=row.getCell(2);
			XSSFCell dob=row.getCell(3);
			//System.out.println("usserName:-->"+userName+ "password:-->"+password);
			obj=new OrangeHrm_Repository(driver);
			//Thread.sleep(3000);
			obj.Name.sendKeys(name.toString());
			obj.dob.sendKeys("2022-06-07");
			obj.SelectRelation.click();
			Actions act=new Actions(driver);
		    act.sendKeys(Keys.ARROW_DOWN).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
			obj.Depsavebtn.click();
			
			Thread.sleep(3000);
			
		}
    	
    	
    }
    @Test(priority=9)
    public void blankDependents() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.Depsavebtn.click();
		Thread.sleep(3000);
		String g=obj.err.getText();
		Assert.assertEquals(g, "Required");
		Thread.sleep(3000);
    	
    }
    
    @Test(priority=10)
    public void Validate_cancel() throws InterruptedException, IOException
    {
    	obj=new OrangeHrm_Repository(driver);

    	String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows =sheet.getLastRowNum();
		System.out.println("number of rows:" +rows);
		for(int r=2;r<=2;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell name=row.getCell(2);
			XSSFCell dob=row.getCell(3);
			obj=new OrangeHrm_Repository(driver);
			obj.Name.sendKeys(name.toString());
			obj.dob.sendKeys("2022-06-07");
			obj.SelectRelation.click();
			Actions act=new Actions(driver);
		    act.sendKeys(Keys.ARROW_DOWN).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
			obj.Cancel.click();
			System.out.println("validate cancel button");
			Thread.sleep(3000);
			
    }

}
    @Test(priority=11)
    public void oneCred() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.Name.click();
    	Actions act=new Actions(driver);
    	act.sendKeys(Keys.NUMPAD2).build().perform();
    	obj.Depsavebtn.click();
    	String h=obj.err.getText();
    	Assert.assertEquals(h,"Required");
    	System.out.println("one credential");
    	obj.Cancel.click();
    	Thread.sleep(3000);
    	
    }
    
    @Test(priority=12)
    public void Add_Attachment() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	Thread.sleep(3000);
    	obj.attachBtn.click();
    	Thread.sleep(3000);
    	
    }
    
    @Test(priority=13)
    public void Attach_Valid() throws IOException, InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	
    	Thread.sleep(3000);
    	String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows =sheet.getLastRowNum();
		System.out.println("number of rows:" +rows);
		for(int r=2;r<=2;r++)
		{
			XSSFRow row=sheet.getRow(r);
			XSSFCell file=row.getCell(4);
			XSSFCell comment=row.getCell(5);
			obj=new OrangeHrm_Repository(driver);
			obj.file.sendKeys(file.toString());
			obj.comment.sendKeys(comment.toString());
			obj.AssisnSaveBtn.click();
			
			
			Thread.sleep(2000);
			
    }
    }
    @Test(priority=14)
    public void Attach_blank() throws InterruptedException
    {
    	
    	obj=new OrangeHrm_Repository(driver);
        
    	obj.AssisnSaveBtn.click();
    	String Z=obj.Error.getText();
    	Assert.assertEquals(Z,"Required");
    	Thread.sleep(3000);
    }
    
    @Test(priority=15)
    public void AttachCancelBtn() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.CancelAttach.click();
    	Thread.sleep(3000);
    	
    }
    @Test(priority=16)
    public void DeleteAss() throws InterruptedException
    {
    	Actions act=new Actions(driver);
    	act.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
    	obj=new OrangeHrm_Repository(driver);
    	obj.DeleteSym.click();
  		obj.DependCheckbox.click();
  		obj.DepPopup.click();
  		Thread.sleep(3000);
  		
    }

    @Test(priority=17)
    public void deleteAttac() throws InterruptedException
    {
    	obj=new OrangeHrm_Repository(driver);
    	obj.AssignCheckbx.click();
		obj.DeltBtn.click();
		obj.DeltPopUp.click();
		Thread.sleep(3000);		
    }
    @AfterSuite
    public void quit()
    {
    	driver.close();
    }
 
}


	
	
	
