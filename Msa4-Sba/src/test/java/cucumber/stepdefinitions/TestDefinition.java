package cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import msa4.sba.pageobject.HomePageObject;
import msa4.sba.runner.TestRunner;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.Reporting;

public class TestDefinition extends TestRunner
{
	Scenario scene;

	@Before("@one")
	public void Report()
	{
		BaseClass.ExecutionFlag = false;
		reportObject = new Reporting();
	}

	@Before
	public void initObjects(Scenario current)
	{
		this.scene = current;
		baseObject = new BaseClass();
		homeObject = new HomePageObject();
	}

	@After()
	public void flushReport()
	{
		BaseClass.ExecutionFlag = false;
		BaseClass.ext.flush();
	}

	@Given("^(.+) driver is initialized$")
	public void driver_is_initialized(String driverType)
	{
		BaseClass.ts = BaseClass.ext.createTest(scene.getName());
		driver = baseObject.initializeDriver(5, "Configure", driverType);
	}

	@And("^User navigates to (.+) website homepage$")
	public void user_navigates_to_website_homepage(String website)
	{
		baseObject.navigateToUrl(driver, "Configure", website);
	}

	@When("User hovers over Products")
	public void user_enters_into_search_box()
	{
		homeObject.hoverOnProducts(driver);
	}
	@And("Clicks on Mach3")
	public void clicks_on_mach_3()
	{
		homeObject.clickOnMach3(driver);
	}

	@Then("^(.+) should be present on results page$")
	public void should_be_present_on_results_page(String resultText)
	{
		productsObject.verifyProductResult(driver, resultText);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button()
	{
		homeObject.clickOnSearchButton(driver);
	}
	@And("^Enters (.+) into search box$")
	public void enters_into_search_box(String input)
	{
		homeObject.enterIntoSearchBoxEnter(driver,input);
	}
	
	@Then("^(.+) should be displayed on top of results page$")
	public void should_be_displayed_on_top_of_results_page(String str)
	{
		searchObject.verifySearchResult(driver, str);
	}
	@When("User clicks Styling link in footer section")
	public void user_clicks_styling_link_in_footer_section()
	{
		homeObject.clickOnFooterStyling(driver);
	}

	@Then("^(.+) should be present under style articles$")
	public void should_be_present_under_style_articles(String style)
	{
		footerObject.verifyFooterResult(driver, style);
	}

}
