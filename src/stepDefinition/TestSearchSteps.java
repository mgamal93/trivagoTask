package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSearchSteps extends BaseUtil {
	private BaseUtil base;
	WebElement searchIcon;
	WebElement searchKeyWord;

	public TestSearchSteps(BaseUtil base) {
		this.base = base;
	}

	@Given("^User in home page$")
	public void user_in_home_page() {
		base.driver = new ChromeDriver();
		base.driver.navigate().to("https://magazine.trivago.com/");
	}

	@When("^User enters search key \"([^\"]*)\"$")
	public void user_enters_search_key(String keyWord) {
		searchIcon = base.driver.findElement(By.className("search-icon"));
		searchIcon.click();

		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		searchKeyWord = base.driver.findElement(By.className("search-input"));
		searchKeyWord.sendKeys(keyWord);
		searchKeyWord.sendKeys(Keys.ENTER);
	}

	@Then("^User should find the search result successfully$")
	public void user_should_find_the_search_result_successfully() {
		WebDriverWait wait = new WebDriverWait(base.driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("section-title")));

		String searchResultTitleAR = base.driver.findElement(By.className("section-title")).getText();
		String searchResultTitleER = "6 Search Results";
		System.out.println("the actual result is:" + searchResultTitleAR);
		Assert.assertEquals(searchResultTitleER, searchResultTitleAR);
	}

}
