package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenaricLibraries.WebDriverutility;

/**
 * this contains element respective libraries of Selenium training page
 * 
 * @author dileep
 *
 */
public class SeleniumTrainingPage {
	// Declaration
	@FindBy(xpath = "//h1[@class=\"page-header\"]")
	private WebElement pageheader;

	@FindBy(id = "add")
	private WebElement plusbutton;

	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(xpath = "//button[.=' Add to Cart']")
	private WebElement addtocart;

	@FindBy(xpath = "//div[@class='callout callout-success']/span")
	private WebElement message;

	// Initialization
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// utilization
	/**
	 * this method returns page header of selenium training page
	 * 
	 * @return
	 */
	public String getpageheader() {
		return pageheader.getText();
	}

	/**
	 * this mthod used to double click on plus button
	 * 
	 * @param web
	 */
	public void doubleclickPlus(WebDriverutility web) {
		web.DoubleclickElement(plusbutton);

	}

	/**
	 * this method used to tell quantity
	 * 
	 * @return
	 */
	public String getQuantity() {
		return quantity.getAttribute("value");
	}

	/**
	 * this method used click on cart
	 */
	public void clickToCart() {
		addtocart.click();
	}

	/**
	 * this method return message from cart
	 * 
	 * @return
	 */
	public String getmessage() {
		return message.getText();

	}
}
