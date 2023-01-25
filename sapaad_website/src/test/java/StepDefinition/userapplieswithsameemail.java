package StepDefinition;

import base.Config;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SapaadTrailPage;

public class userapplieswithsameemail extends Config{
	HomePage home = new HomePage(driver);
	SapaadTrailPage trail = new SapaadTrailPage(driver);
	@Given("User is on sapaad Homepage")
	public void user_is_on_sapaad_homepage() {
		home.dismisspopupmodal();
	}

	@When("user clicks on try free button trail page should be displayed")
	public void user_clicks_on_try_free_button_trail_page_should_be_displayed() {
		home.click_try_free();
	}

	@And("^I enter existing (.*) address$")
	public void i_enter_existing_email_address(String email) {
		trail.enter_email_Id(email);
		
	}

	@Then("I get a message the email already exists and get a link for login")
	public void i_get_a_message_the_email_already_exists_and_get_a_link_for_login() {
		trail.existing_email_address();
		driver.quit();
	}
}
