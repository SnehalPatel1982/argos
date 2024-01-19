package steps;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage = new SearchPage(DriverFactory.getdriver());


    @Given("user go to argos website")
    public void user_go_to_argos_website() {
        System.out.println("This is Search Steps page");
        DriverFactory.getdriver().get("https://www.argos.co.uk/");
        String Actual = searchPage.setURL();
        Assert.assertThat(Actual, Matchers.endsWith("argos.co.uk/"));
    }

    @Then("user accept cookies")
    public void user_accept_cookies() {
        searchPage.setCookies();
    }

    @Then("user enter {string} product on search box")
    public void user_enter_product_on_search_box(String product) {
        searchPage.setSearchtext(product);
    }

    @When("user click on search button")
    public void user_click_on_search_button() {
        searchPage.setSearchbutton();
    }


    @Then("user must see all {string}")
    public void user_must_see_all(String product) {
        Assert.assertThat(searchPage.setLabeltext(), Matchers.equalTo(product));
    }

}
