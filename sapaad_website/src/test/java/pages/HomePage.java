package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Config;

public class HomePage extends Config{

	@FindBy(xpath = "//div[@class='d-none d-md-block']")
	private WebElement popup;
	@FindBy(xpath = "(//span[contains(text(),'×')])[3]")
 	private WebElement dismiss_popup;
	@FindBy(xpath = "(//a[contains(text(),'Try for free')])[1]")
	private WebElement try_free_button;
	@FindBy(xpath = "(//a[contains(text(),'Schedule a Demo')])[1]")
	private WebElement btn_scheduledemo;
	@FindBy(xpath = "(//a[contains(text(),'Pricing')])[1]") WebElement Pricing;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dismisspopupmodal() {
		try {
			Thread.sleep(5000);
			dismiss_popup.click();
		} catch (InterruptedException e) {
			System.out.println("AWWWW exception occured");
			e.printStackTrace();
		}
		

	}

	public void click_try_free() {
		try {
			Thread.sleep(5000);
			try_free_button.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void click_scheduledemo() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",btn_scheduledemo);
	
	}
	public void pricingpage() {
		Actions a = new Actions(driver);
		a.moveToElement(Pricing).perform();
		a.click(Pricing).perform();
		//hello commited first changes
		//A new change is updated
	}
}
//