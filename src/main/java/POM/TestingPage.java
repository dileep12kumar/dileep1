package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains elements and respective business libraries of Testing page
 * @author dileep
 *
 */
public class TestingPage {
	// Declaration
	@FindBy(xpath = "//h1[@class=\"page-header\"]")
	private WebElement pageheader;

	@FindBy(id = "Python")
	private WebElement pythonimg;

	@FindBy(id = "cartArea")
	private WebElement cartarea;

	@FindBy(xpath = "//ul/descendant::i[@class=\"fa fa-facebook\"]")
	private WebElement facebookicon;

	// initialization
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**\
	 * this method return page header odf selenium training page
	 * @return
	 */

	// utilization
	public String getpageheader() {
		return pageheader.getText();
	}
	/**
	 * this method get python imge 
	 * @return
	 */

	public WebElement getpythonimage() {
		return pythonimg;
	}
	/**
	 * this method get cart details
	 * @return
	 */

	public WebElement getmycart() {
		return cartarea;
	}
	/**
	 * this method get webElement facebook 
	 * @return
	 */

	public WebElement getfacebookIcon() {
		return facebookicon;
	}
	/**
	 * this method click on facebook icon on page
	 */

	public void clickfacebook() {
		facebookicon.click();
	}
}
