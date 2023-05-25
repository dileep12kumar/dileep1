package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains respective libraries of selenium of Contactus page
 * 
 * @author Dileep
 *
 */
public class ContactUs {
	// Declaration
	@FindBy(xpath = "//img[contains(@src, 'contactus')]")
	private WebElement pagelogo;

	@FindBy(name = "name")
	private WebElement fullnameTf;

	@FindBy(name = "sender")
	private WebElement gmailTf;

	@FindBy(name = "subject")
	private WebElement subjectTf;

	@FindBy(name = "message")
	private WebElement messageTf;

	@FindBy(xpath = "//button[text()=\"Send us mail\"]")
	private WebElement sendGmail;

	// Initiation
	public ContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	/**
	 * this method return log
	 * 
	 * @return
	 */
	// Utilization
	public WebElement getpagelogo() {
		return pagelogo;
	}

	/**
	 * this method send all details
	 * 
	 * @param Fullname
	 * @param Email
	 * @param Subject
	 * @param Message
	 */
	public void sendDetails(String Fullname, String Email, String Subject, String Message) {
		fullnameTf.sendKeys(Fullname);
		gmailTf.sendKeys(Email);
		subjectTf.sendKeys(Subject);
		messageTf.sendKeys(Message);
		sendGmail.click();
	}
}
