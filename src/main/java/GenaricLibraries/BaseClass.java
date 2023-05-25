package GenaricLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.ContactUs;
import POM.SeleniumTrainingPage;
import POM.SkillraryDemopage;
import POM.SkillraryHomePage;
import POM.TestingPage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtiliy excel;
	protected WebDriverutility web;
	protected WebDriver driver;
	
	protected SkillraryDemopage demo;
	protected SkillraryHomePage home;
	protected TestingPage testing;
	protected SeleniumTrainingPage selenium;
	protected ContactUs contact;
	

	// @BeforeSuite
	// @BeforeTest

	@BeforeClass

	public void classConfig() {

		property = new PropertiesUtility();
		excel = new ExcelUtiliy();
		web = new WebDriverutility();

		property.propertyInti(IConstancepath.PROPERTIES_PATH);

		excel.ExcelInti(IConstancepath.Excel_path);

	}

	@BeforeMethod
	public void methodconfig() 
	{
		driver = web.lunchbrowser(property.ReadData("browser"));
		web.maximizeBrowser();
		web.NavigateToApp(property.ReadData("url"));
		web.WaitutilElemnt(Long.parseLong(property.ReadData("time")));

		
		home=new SkillraryHomePage(driver);
		demo=new SkillraryDemopage(driver);
		testing=new TestingPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		contact=new ContactUs(driver);
		
		home.Chooselanuage();

	}


	
	@AfterMethod
	public void methodTearDown() 
	{
		web.QuiteAllWindows();

	}
	
	@AfterClass
	public void classTearDown() 
	{
		excel.closeExcel();
	}

	// @AfterSuite
	// @AfterTest

}
