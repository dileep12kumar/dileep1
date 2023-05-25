package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {
//Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;

	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearsTab;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu ')]/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement SkillraryDemoAppLink;
	
	@FindBy(xpath = "//ul[contains(@class, \"home_menu\")]/li[1]")
	private WebElement lanuage;
	
	@FindBy(xpath = "//ul[contains(@class, \"home_menu\")]/descendant::a[text()=\" English\"]")
	private WebElement english;
	

	// Initialization
	public SkillraryHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	/**
	 * this method is returns skillrary Home Page
	 * 
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}

	/**
	 * this method is used click on gears Tab
	 * 
	 * @param gearsTab
	 * 
	 */
	public void ClickGearsTab() {
		gearsTab.click();
	}

	/**
	 * this method is used to click on Skillrary Demo app link
	 * 
	 * @param SkillraryDemoApplink
	 */
	public void SkillraryDemoApp() {
		SkillraryDemoAppLink.click();
	}
	public void Chooselanuage() {
		lanuage.click();
		english.click();
	}

}
