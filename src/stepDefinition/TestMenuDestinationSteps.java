package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestMenuDestinationSteps extends BaseUtil {

	private BaseUtil base;

	public TestMenuDestinationSteps(BaseUtil base) {
		this.base = base;
	}

	@When("^User click on menu button$")
	public void user_click_on_menu_button() {
		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement menuButton = base.driver.findElement(By.className("nav-icon"));
		menuButton.click();
		WebElement menuItem = base.driver.findElement(By.className("menu-title"));
		menuItem.click();

	}

	@When("^User expand a destinations menu item and select a specific destination$")
	public void user_expand_a_destinations_menu_item_and_select_a_specific_destination() {
		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement menuDestinationCard = base.driver.findElement(By.className("swiper-slide-active"));
		menuDestinationCard.click();

	}

	@Then("^User should be redirected to the specific destination page$")
	public void user_should_be_redirected_to_the_specific_destination_page() {
		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String destinationTitleAR = base.driver.findElement(By.className("hero-main-title dest-2-main-title"))
				.getText();
		System.out.println(destinationTitleAR);
		String destinationTitleER = "Northwest";
		Assert.assertEquals(destinationTitleER, destinationTitleAR);

	}

}
