package TestScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenaricLibraries.BaseClass;

public class AddtoCart extends BaseClass
{
	@Test
	public void addtoCart() {
		
		SoftAssert soft=new SoftAssert();
		
		home.ClickGearsTab();
		home.SkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertTrue(demo.getlogo().contains("ECommerce"));
		demo.mouseoverToCourse(web);
		demo.ClickSeleniumTraining();
		
		soft.assertEquals(selenium.getpageheader(), "Selenium Training");
		
		int InitialQuantity=Integer.parseInt(selenium.getQuantity());
		
		selenium.doubleclickPlus(web);
		int finalQuantity=Integer.parseInt(selenium.getQuantity());
		
		soft.assertEquals(finalQuantity, InitialQuantity+1);
		
		selenium.clickToCart();
		web.handleAlert("ok");
		soft.assertEquals(selenium.getmessage(), "Item added to cart");
		
		soft.assertAll();
	}

	
}
