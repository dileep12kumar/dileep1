package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenaricLibraries.WebDriverutility;

/**
 * This method is contains elements and respective business liabraries for
 * Skillrary Demo App page
 * 
 * @author dileep
 *
 */
public class SkillraryDemopage {
	@FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement logo;

	@FindBy(id = "course")
	private WebElement courseTab;

	@FindBy(xpath = "//span/a[text()='Selenium Training']")
	private WebElement seleniumTraininglink;

	@FindBy(name = "addresstype")
	private WebElement categoryDD;

	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactUslink;

//initialization

	public SkillraryDemopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilization
	/**
	 * This method is used to return text on the logo
	 * 
	 * @return
	 */
	public String getlogo() {
		return logo.getText();
	}

	/**
	 * this method is used to mouseover on course tab
	 * 
	 * @param web
	 */
	public void mouseoverToCourse(WebDriverutility web) {

		web.MOuseOver(courseTab);
	}

	/**
	 * this method is used to click On Selenium Training
	 */
	public void ClickSeleniumTraining() {
		seleniumTraininglink.click();
	}

	/**
	 * this method is used to select catagory from drop Down on index
	 * 
	 * @param index
	 * @param Web
	 * @param index
	 */
	public void SelectCatagory(WebDriverutility web, int index) {
		web.DropDown(categoryDD, index);

	}

	/**
	 * this method is return the contact us link
	 * 
	 * @return
	 */
	public WebElement getContactUs() {
		return contactUslink;
	}

	public void ClickContactUs() {
		contactUslink.click();
	}
}