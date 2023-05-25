package TestScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenaricLibraries.BaseClass;

public class addTestingcourseToMycart extends BaseClass

{

	@Test
	public void addpythonToMycart() {
		SoftAssert soft = new SoftAssert();
		
		home.ClickGearsTab();
		home.SkillraryDemoApp();
		web.handleChildBrowser();

		soft.assertTrue(demo.getlogo().contains("ECommerce"));
		demo.SelectCatagory(web, 1);

		soft.assertEquals(testing.getpageheader(), "Testing");

		web.ScrollElement(testing.getpythonimage());
		web.DragAndDropElement(testing.getpythonimage(), testing.getmycart());

		web.ScrollElement(testing.getfacebookIcon());
		testing.clickfacebook();

		soft.assertAll();

	}

}
