package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ScheduledemoPage;

public class Scheduledemosteps {
	public WebDriver driver;
	HomePage home;
	ScheduledemoPage scheduldemo;
	@Given("User is on sapaad home")
	public void user_is_on_sapaad_home() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www-review.sapaad.com");
		home = new HomePage(driver);
		home.dismisspopupmodal();
		
	}

	@When("user click on Schedule  demo button")
	public void user_click_on_schedule_demo_button() {
		home.click_scheduledemo();
	}

	@When("Schedule demo page opens")
	public void schedule_demo_page_opens() {
			try {
				String title = driver.getTitle();
				if(title.equals("Schedule a Demo - Sapaad")) {
					System.out.println("I am on schedule dmeo page");
					TakesScreenshot ts = (TakesScreenshot)driver;
					File src = ts.getScreenshotAs(OutputType.FILE);
					File dest = new File("./Snapshots/scheduledemo.png");
				FileUtils.copyFile(src, dest);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	@When("user selects there role restaurant type")
	public void user_selects_there_role_restaurant_type() {
		scheduldemo = new ScheduledemoPage(driver);
		scheduldemo.dropdownselection();
		
	}

	@When("the number of Outlets they have and click on continue")
	public void the_number_of_outlets_they_have_and_click_on_continue() {
		System.out.println("user has click on continue taking to the form");
	}

	@When("^user enters there contact details (.*) and (.*) and (.*) and (.*) and submits the form$")
	public void enter_contact_form_details(String name,String email, String restaurant, String phone) {
		scheduldemo.enterformdetails(name, email, restaurant, phone);
	}

	@Then("User gets a message thank you for your interest")
	public void user_gets_a_message_thank_you_for_your_interest() {
		scheduldemo.user_gets_message_thank_you();
		driver.quit();
	}

}
