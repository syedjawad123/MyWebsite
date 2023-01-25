package StepDefinition;

import base.Config;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SapaadTrailPage;

public class trail extends Config{

	HomePage home = new HomePage(driver);
	SapaadTrailPage trail = new SapaadTrailPage(driver);

	@Given("User is on sapaad homepage")
	public void user_is_on_sapaad_homepage() {
		home.dismisspopupmodal();
	}

	@When("User clicks on try free button")
	public void user_clicks_on_try_free_button() {
		home.click_try_free();

	}

	@And("^I enter a valid (.*) address and click on continue$")
	public void i_enter_a_valid_address_and_click_on_continue(String email) {
		trail.enter_email_Id(email);
	}

	@And("^I enter the form details with (.*) (.*) (.*)$")
	public void i_enter_the_form_details_with(String name, String restaurantname, String phone) {
		trail.enter_form_details(name, restaurantname, phone);
	}

	@And("I click on agree button and submit the details")
	public void i_click_on_agree_button_and_submit_the_details() {
		trail.submit_form();
	}

	@Then("User gets a message thank you for submitting the form")
	public void user_gets_a_message_thank_you_for_submitting_the_form() {
		trail.congratulation();
		driver.quit();
	}
}
