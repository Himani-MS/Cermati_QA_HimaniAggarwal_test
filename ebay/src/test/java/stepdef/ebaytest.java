
package stepdef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ebaytest{
	
	WebDriver driver;

	public ebaytest(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
private static final Logger LOG = LoggerFactory.getLogger(ebaytest.class);
Scenario scenario;
public ebaytest() {}
public ebaytest(Scenario scenario) {
	
	this.scenario = scenario;
}
@Given("Go to www ebay com")
public void go_to_www_ebay_com() {
	driver.get("www.ebay.com");
	}

@Given("Type any search string in the search bar")
public void type_any_search_string_in_the_search_bar() {
    driver.findElement(By.id("gh-ac")).sendKeys("MacBook");

}

@Then("Change the Search category")
public void change_the_search_category() {
    driver.findElement(By.id("gh-ac")).sendKeys("electronics");

}

@Then("click Search")
public void click_search() {
    driver.findElement(By.id("gh-btn")).click();

}

@Then("Verify that the page loads completely")
public void verify_that_the_page_loads_completely() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Verify that the first result name matches with the search string")
public void verify_that_the_first_result_name_matches_with_the_search_string() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("navigate to search by category and electronics")
public void navigate_to_search_by_category_and_electronics() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("click cellphone and smart phone")
public void click_cellphone_and_smart_phone() {
    driver.findElement(By.xpath("//select[@id='gh-cat']")).click();
    driver.findElement(By.xpath("//select[@id='gh-cat']")).sendKeys("electronic");
}

@Then("cclick on see all")
public void cclick_on_see_all() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("check fillters")
public void check_fillters() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("apply filters")
public void apply_filters() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

}