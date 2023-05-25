package TestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenaricLibraries.BaseClass;

public class SendContactDetails extends BaseClass
{

	@Test
	public void sendContactDetails() 
	{
		SoftAssert soft=new SoftAssert();
				
		home.ClickGearsTab();
		home.SkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(demo.getlogo().contains("ECommerce"));
		
		web.ScrollElement(demo.getContactUs());
		demo.ClickContactUs();
		
		soft.assertTrue(contact.getpagelogo().isDisplayed());
		
		home.Chooselanuage();
		
		Map<String, String> map=excel.ReadDataFromExcel("Sheet1");
		contact.sendDetails(map.get("FullName"), map.get("Email"), map.get("subject"), map.get("Message"));
		
		soft.assertAll();
	}
}
