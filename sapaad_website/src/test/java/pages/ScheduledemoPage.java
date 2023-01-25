package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Config;

public class ScheduledemoPage extends Config {
	WebDriver driver;
	@FindBy(xpath = "//select[@name='your-role']")
	WebElement roledropdown;
	@FindBy(xpath = "//select[@name='restaurant-type']")
	WebElement restauranttypedropdown;
	@FindBy(xpath = "//select[@name='total-outlets']")
	WebElement numberofoutletsdropdown;
	
	@FindBy(name = "your-name")
	WebElement txt_schduledemo_name;
	@FindBy(name = "your-email")
	WebElement txt_schduledemo_email;
	@FindBy(name  = "resto-name")
	WebElement txt_schduledemo_restaurantname;
	@FindBy(name = "phone-num")
	WebElement txt_schduledemo_phone;
	
	@FindBy(xpath = "//span[contains(text(),'Continue >')]")
	WebElement schduledemo_submit_step1;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement schduledemo_submit_step2;
	@FindBy(xpath = "//p[@class ='header']")
	WebElement thank_you_schduledemo;
	
	public ScheduledemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void dropdownselection() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(roledropdown));
		Select s1 = new Select(roledropdown);
		Select s2 = new Select(restauranttypedropdown);
		Select s3 = new Select(numberofoutletsdropdown);
		s1.selectByValue("Manager");
		s2.selectByValue("Fine Dining Restaurant");
		s3.selectByValue("2-5 Outlets");
		schduledemo_submit_step1.click();
	}
	
	public void enterformdetails(String name, String email,String restaurant,String phone) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(txt_schduledemo_name));
		txt_schduledemo_name.click();
		txt_schduledemo_name.sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(txt_schduledemo_email));
		txt_schduledemo_email.click();
		txt_schduledemo_email.sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(txt_schduledemo_restaurantname));
		txt_schduledemo_restaurantname.click();
		txt_schduledemo_restaurantname.sendKeys(restaurant);
		wait.until(ExpectedConditions.elementToBeClickable(txt_schduledemo_phone));
		txt_schduledemo_phone.click();
		txt_schduledemo_phone.sendKeys(phone);
		wait.until(ExpectedConditions.elementToBeClickable(schduledemo_submit_step2));
		schduledemo_submit_step2.click();
		
	}
	
	public void user_gets_message_thank_you() {
		WebDriverWait wait  = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(thank_you_schduledemo));
		if(thank_you_schduledemo.isDisplayed()) {
			System.out.println("Demo request was successful");
		}
	}

}
//