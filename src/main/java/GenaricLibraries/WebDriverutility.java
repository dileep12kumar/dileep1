package GenaricLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverutility {
	private WebDriver driver;

	/**
	 * this method is used to lunch the specific browser
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver lunchbrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("invalid browser");
			break;
		}
		return driver;
	}

	/**
	 * this method is to maximize the window
	 * 
	 * @param url
	 */
	public void NavigateToApp(String url) {
		driver.get(url);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * this method used to wait until element or list of Elements is found
	 * 
	 * @param time
	 */

	public void WaitutilElemnt(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	/**
	 * this method is used to wait until element is visible
	 * 
	 * @param time
	 * @param element
	 * @return
	 */

	public WebElement ExplicitlyWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * this method is used to wait until elements enable
	 * 
	 * @param time
	 * @param element
	 * @return
	 */

	public WebElement ExplicitlyWait(long time, By element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * this method used to mouse over on an element
	 * 
	 * @param element
	 */

	public void MOuseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * this method used to double click on element
	 * 
	 * @param element
	 */
	public void DoubleclickElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	/**
	 * this method used to right click on element
	 * 
	 * @param element
	 */

	public void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * this method used to drap&down on element
	 * 
	 * @param dest
	 * @param Element
	 */
	public void DragAndDropElement(WebElement dest, WebElement Element) {
		Actions action = new Actions(driver);
		action.dragAndDrop(Element, dest).perform();
	}

	/**
	 * this method is used to switch to frame based on id or name attribute
	 * 
	 * @param IdOrName
	 */
	public void SwitchtoFrame(String IdOrName) {
		driver.switchTo().frame(IdOrName);

	}

	/**
	 * this method used to switch frame based on frame element
	 * 
	 * @param frameElement
	 */

	public void SwitchtoFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * this method is used to switch back from frame
	 */

	public void SwitchtoFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to take ScreenShot of WeBpage
	 * 
	 */
	public void ScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/ScreenShot.png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method used to Scroll tiil the element
	 * 
	 * @param Element
	 */

	public void ScrollElement(Object Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", Element);
	}

	/**
	 * this method select an element drop down using index
	 * 
	 * @param element
	 * @param index
	 */
	public void DropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * this method select an element drop down using value
	 * 
	 * @param element
	 * @param value
	 */
	public void DropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * this method select an element drop down using text
	 * 
	 * @param text
	 * @param element
	 */
	public void DropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * this method handle alert pop up
	 */
	public void handleAlert(String status) {
		Alert a1 = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))

			a1.accept();

		else

			a1.dismiss();

	}

	/**
	 * this method is used to switch to parent class
	 */
	public void SwitchtoParentWindow() {
		String parentId = driver.getWindowHandle();
		driver.switchTo().window(parentId);

	}

	/**
	 * this method is used to switch to chlid class
	 */
	public void handleChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String id : set)
			driver.switchTo().window(id);

	}

	/**
	 * this method close current Tab
	 */
	public void closeCurent() {
		driver.close();
	}

	/**
	 * this method Quite all Tab
	 */
	public void QuiteAllWindows() {
		driver.quit();
	}
}
