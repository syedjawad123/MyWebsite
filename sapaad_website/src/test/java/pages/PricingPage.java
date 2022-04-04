package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
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
	@FindBy(xpath = "//input[starts-with(@type,'range')]")
	WebElement Slider;
	@FindBy(xpath = "//input[@value ='Try for free']")
	WebElement Tryforfreesubmitbutton;
	@FindBy(xpath = "//input[@id= 'opt1']")
	WebElement radiobutton1;
	@FindBy(xpath = "//input[@id= 'opt2']")
	WebElement radiobutton2;
	@FindBy(xpath = "//input[@id='yplan']")
	WebElement yearlyplanbutton;
	@FindBy(xpath = "//span[@class='pricing-total-cls price-bill-plan']")
	WebElement pricingtotal;
	@FindBy(xpath = "(//div[@class='selection'])[1]")
	WebElement checkboxes;
	

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
		if (result == true) {
			System.out.println("user selected single outlet");
		}
	}

	public void users_selects_all_addons() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('a1').click()", "");
		js.executeScript("document.getElementById('a2').click()", "");
		String pricngvalue = pricingtotal.getText();
		System.out.println(pricngvalue);
	}

	public void user_selects_yearly_plan() {
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(yearlyplanbutton));
		if (yearlyplanbutton.isSelected()) {
			String pricing = pricingtotal.getText();
			if (pricing.endsWith("(billed annually)")) {
				System.out.println("user selected for yearly billing");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./Snapshots/pricing2.png");
				try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public void user_clicks_try_free() {
		Tryforfreesubmitbutton.click();
	}

	public void user_selects_muliplte_outlets() {
		boolean multipleoutlets = radiobutton2.isSelected();
		if (multipleoutlets == false)
			radiobutton2.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int value= 0 ; value<=10; value++)
		{
		js.executeScript("$(arguments[0]).val("+value+").change()", Slider);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public void verify_trail_page() {
		String verify_title = driver.getTitle();
		if (verify_title.contains("Sapaad Trial - Sapaad")) {
			System.out.println("Awsome On trail page");
			driver.navigate().back();
		}
	}

}
