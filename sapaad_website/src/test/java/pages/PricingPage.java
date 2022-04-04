package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPage {

	WebDriver driver;
	@FindBy(xpath = "(//a[contains(text(),'Try for free')])[1]")
	WebElement Try_top_button;
	@FindBy(xpath = "//input[@type='range']")
	WebElement Slider;
	@FindBy(xpath = "//input[@value ='Try for free']")
	WebElement Tryforfreesubmitbutton;
	@FindBy(xpath = "//input[@id= 'opt1']")
	WebElement radiobutton1;
	@FindBy(xpath = "//input[@id= 'opt2']")
	WebElement radiobutton2;
	@FindBy(id = "yplan")
	WebElement yearlyplanbutton;
	@FindBy(xpath = "//span[@class='pricing-total-cls price-bill-plan']")
	WebElement pricingtotal;
	@FindBy(xpath = "//input[@id ='a1']")
	WebElement InventoryCheckbox;
	@FindBy(xpath = "//input[@id ='a2']")
	WebElement CRMcheckbox;
	@FindBy(xpath = "//input[@id ='a3']")
	WebElement onlinOrdercheckbox;
	@FindBy(xpath = "//input[@id ='a4x']")
	WebElement loyaltycheckbox;

	public PricingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void user_select_monthly_plan() {
		boolean result = yearlyplanbutton.isSelected();
		if (result == false) {
			System.out.println("user has selected montly plan");
			String pricingvalue = pricingtotal.getText();
			if (pricingvalue.endsWith("$58.99/month")) {
				System.out.println("it is correct");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./Snapshots/pricing.png");
				try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void user_selects_single_outlet() {
		boolean result = radiobutton1.isSelected();
		if(result == true) {
			System.out.println("user selected single outlet");
		}
	} 
	
	public void users_selects_all_addons() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(InventoryCheckbox));
		wait.until(ExpectedConditions.elementToBeClickable(CRMcheckbox));
		wait.until(ExpectedConditions.elementToBeClickable(onlinOrdercheckbox));
		wait.until(ExpectedConditions.elementToBeClickable(loyaltycheckbox));
		InventoryCheckbox.click();
		CRMcheckbox.click();
		onlinOrdercheckbox.click();
		loyaltycheckbox.click();
	}

	public void user_selects_yearly_plan() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(yearlyplanbutton));
		yearlyplanbutton.click();
		String pricing = pricingtotal.getText();
		if(pricing.endsWith("(billed annually)")){
			System.out.println("user selected for yearly billing");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Snapshots/pricing.png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void user_clicks_try_free() {
		Tryforfreesubmitbutton.click();
	}
	
	public void user_selects_muliplte_outlets() {
		radiobutton2.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('outletRange').scrollLeft += 10","");
	}
	
	public void verify_trail_page(){
		String verify_title = driver.getTitle();
		if(verify_title.contains("Sapaad Trial - Sapaad")) {
			System.out.println("Awsome On trail page");
			driver.navigate().back();
		}
	}
	

}
