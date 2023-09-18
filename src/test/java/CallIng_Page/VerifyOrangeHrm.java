package CallIng_Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import OrangeHrm_Pages.AssignedDependent_Page;
import OrangeHrm_Pages.Attachment_page;
import OrangeHrm_Pages.Login_Page;
import OrangeHrm_Pages.MyInfo_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyOrangeHrm {
	XSSFSheet sheet;
	WebDriver driver;
	Login_Page l;
	XSSFWorkbook workbook;
	MyInfo_Page m;
	AssignedDependent_Page a;
	Attachment_page b;
	@BeforeTest
	public void launchBrowser() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	a=new AssignedDependent_Page(driver);
	m=new MyInfo_Page(driver);
	l=new Login_Page(driver);
	b=new Attachment_page(driver);
	
	String filePath="C:\\Users\\admin\\Desktop\\TestData.xlsx";
	FileInputStream fis=new FileInputStream(filePath);
	workbook=new XSSFWorkbook(fis);
	sheet=workbook.getSheet("Sheet1");
	}
	@Test(priority=1)
	public void OrangeHrmTest() throws IOException, InterruptedException
	{
	int rows =sheet.getLastRowNum();
	System.out.println("number of rows:" +rows);
	for(int r=1;r<=3;r++)
	{
		
		XSSFRow row=sheet.getRow(r);
		System.out.println(sheet.getRow(1).getCell(1).toString());
		XSSFCell userName=row.getCell(0);
		XSSFCell password=row.getCell(1);
		System.out.println("usserName:-->"+userName+ "password:-->"+password);
		l.ussername(userName.toString());
		l.password(password.toString());
		l.loginbtn();
		String actual=l.VerifyInvalid();
		Assert.assertEquals(actual,"Invalid credentials");
	}
	l.loginbtn();
	String actual=l.VerifyRequired();
	Assert.assertEquals(actual,"Required");
	
	for(int r=4;r<=4;r++)
	{
		
		XSSFRow row=sheet.getRow(r);
		System.out.println(sheet.getRow(1).getCell(1).toString());
		XSSFCell userName=row.getCell(0);
		XSSFCell password=row.getCell(1);
		System.out.println("usserName:-->"+userName+ "password:-->"+password);
		l.ussername(userName.toString());
		l.password(password.toString());
		l.loginbtn();
		m.myinfoClick();
		m.dependentsClick();
		a.AssignDependentClick();
		int rowss =sheet.getLastRowNum();
		System.out.println("number of rows:" +rowss);
		for(int s=1;s<=1;s++)
		{
			XSSFRow rr=sheet.getRow(s);
			XSSFCell name=rr.getCell(2);
			XSSFCell dob=rr.getCell(3);
			a.name(name.toString());
			a.dateOfBirth();
			a.Relationship();
			a.savebtnClick();
			Thread.sleep(3000);
		}
		a.AssignDependentClick();
		a.savebtnClick();
		String act=a.VerifyRequired();
		Assert.assertEquals(act,"Required");
		int rowsss =sheet.getLastRowNum();
		System.out.println("number of rows:" +rowsss);
		for(int s=2;s<=2;s++)
		{
			XSSFRow rr=sheet.getRow(s);
			XSSFCell name=rr.getCell(2);
			XSSFCell dob=rr.getCell(3);
			a.name(name.toString());
			a.dateOfBirth();
			a.Relationship();
			a.cancelClick();
		}
		   a.AssignDependentClick();
		   a.oneCred();
		   a.savebtnClick();
		   String x=a.VerifyRequired();
		   Assert.assertEquals(x,"Required");
		   a.cancelClick();
		   b.clickOnAdd();
		   int ro =sheet.getLastRowNum();
			System.out.println("number of rows:" +rows);
			for(int t=2;t<=2;t++)
			{
				XSSFRow rown=sheet.getRow(t);
				XSSFCell file=rown.getCell(4);
				XSSFCell comment=rown.getCell(5);
				b.file(file.toString());
				b.comment(comment.toString());
				b.saveBtn();
			}
			b.clickOnAdd();
            b.saveBtn();
			String z=b.verifyRequired();
			Assert.assertEquals(z,"Required");
			b.cancelClick();
			a.pgup();
			a.deletecheck();
			a.an();
			a.ac();
			b.checkbox();
			b.cc();
			b.dd();			
	}
	
}
}
