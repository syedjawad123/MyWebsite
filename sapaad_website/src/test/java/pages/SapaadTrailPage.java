package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Config;

public class SapaadTrailPage extends Config{
	@FindBy(id = "your-email")
	WebElement txt_email;
	@FindBy(id = "step-one-btn")
	WebElement button1_continue;
	@FindBy(id = "name")
	WebElement txt_name;
	@FindBy(id = "phone-num")
	WebElement txt_phone;
	@FindBy(id = "terms-agree")
	WebElement i_agree_checkbox;
	@FindBy(id = "step-two-btn")
	WebElement button2_continue;
	@FindBy(id = "resto-name")
	WebElement txt_restaurantname;
	@FindBy(className = "header")
	WebElement congratulations_msg;
	@FindBy(xpath = "//div[@id ='alert-msg']")
	WebElement alertmessage;
	@FindBy(xpath = "(//a[contains(text(),'Log In')])[1]")
	WebElement posLoginlink;
	@FindBy(id = "trial-country")
	WebElement countrySelection;

	public SapaadTrailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void enter_email_Id(String email) {
		txt_email.sendKeys(email);
		button1_continue.click();
	}

	public void enter_form_details(String name, String restaurantname, String phone) {
		
		try {
			txt_name.sendKeys(name);
			Thread.sleep(2);
			txt_restaurantname.sendKeys(restaurantname);
			Thread.sleep(2);
			txt_phone.sendKeys(phone);
			if (i_agree_checkbox.isSelected()) {
				System.out.println("thank you for checking the box");
			} else {
				i_agree_checkbox.click();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void submit_form() {
		button2_continue.click();
	}

	public void congratulation() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(congratulations_msg));
		String congrats = congratulations_msg.getText();
		if (congrats.startsWith("Congratulations")) {
			System.out.println("trail applied successfully");
		}
		else if(congrats.startsWith("Thank you")) {
			System.out.println("Please wait for our team to verify the account");
		}
		
	}
	public void existing_email_address() {
		System.out.println("User entered existing email address");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(posLoginlink));
		posLoginlink.click();
		 Set<String> whs = driver.getWindowHandles();
		 Iterator<String> it = whs.iterator();
		 String Mainwindow = it.next();
		 String Childwinow = it.next();
		 driver.switchTo().window(Childwinow);
		 System.out.println(driver.getCurrentUrl());
//		
	}
}
