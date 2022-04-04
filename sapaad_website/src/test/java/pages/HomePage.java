package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public WebDriver driver;
	@FindBy(xpath = "//div[@class='d-none d-md-block']")
	WebElement popup;
	@FindBy(xpath = "(//span[contains(text(),'×')])[3]")
	WebElement dismiss_popup;
	@FindBy(xpath = "(//a[contains(text(),'Try for free')])[1]")
	WebElement try_free_button;
	@FindBy(xpath = "(//a[contains(text(),'Schedule a Demo')])[1]")
	WebElement btn_scheduledemo;
	@FindBy(xpath = "(//a[contains(text(),'Pricing')])[1]") WebElement Pricing;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void dismisspopupmodal() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(popup));
		dismiss_popup.click();

	}

	public void click_try_free() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(try_free_button));
		try_free_button.click();
	}
	public void click_scheduledemo() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",btn_scheduledemo);
	
	}
	public void pricingpage() {
		Pricing.click();
	}
}
