package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.SapaadTrailPage;

public class userapplieswithsameemail {
	public WebDriver driver;
	HomePage home;
	SapaadTrailPage trail;
	@Given("User is on sapaad Homepage")
	public void user_is_on_sapaad_homepage() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www-review.sapaad.com");
		home = new HomePage(driver);
		home.dismisspopupmodal();
	}

	@When("user clicks on try free button trail page should be displayed")
	public void user_clicks_on_try_free_button_trail_page_should_be_displayed() {
		home.click_try_free();
	}

	@And("^I enter existing (.*) address$")
	public void i_enter_existing_email_address(String email) {
		trail = new SapaadTrailPage(driver);
		trail.enter_email_Id(email);
		
	}

	@Then("I get a message the email already exists and get a link for login")
	public void i_get_a_message_the_email_already_exists_and_get_a_link_for_login() {
		trail.existing_email_address();
		driver.quit();
	}
}
