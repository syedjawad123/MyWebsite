package StepDefinition;



import base.Config;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.PricingPage;

public class PricingSteps extends Config{
	
	HomePage home = new HomePage(driver);
	PricingPage pricing = new PricingPage(driver);
	@Given("user is on homepage")
	public void user_is_on_homepage() {
		home.dismisspopupmodal();
	
	}

	@When("User click on pricing it should take to pricing page")
	public void user_click_on_pricing_it_should_take_to_pricing_page() {
		home.pricingpage();
	 	String tilepricing = driver.getTitle();
	 	if(tilepricing.equals("Pricing - Sapaad")) {
	 		System.out.println("Pricng page is loading");
	 	}
	}

	@And("User selects a single outlet it should show as the selected plan is for one month")
	public void user_selects_a_single_outlet_it_should_show_as_the_selected_plan_is_for_month() {
		pricing = new PricingPage(driver);
		pricing.user_selects_single_outlet();
	}

	@And("User selects all the Addons")
	public void user_selects_all_the_addons() {
		pricing.users_selects_all_addons();
	}

	@And("click on try free")
	public void click_on_try_free() {
		pricing.user_clicks_try_free();
	}

	@Then("user should be taken to trail page")
	public void user_should_be_taken_to_trail_page() {
		pricing.verify_trail_page();
		driver.quit();
	}

	@And("user toggles the button on for yearly plan it should show billed monthly")
	public void user_toggles_the_button_on_for_yearly_plan_it_should_show_billed_monthly() {
		pricing = new PricingPage(driver);
		pricing.user_selects_yearly_plan();
	}

	@And("User selects multiple outlets")
	public void user_selects_multiple_outlets() {
		pricing.user_selects_muliplte_outlets();
	}


}
//