package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestNewSletterSubscribeSteps extends BaseUtil {
	private BaseUtil base;

	public TestNewSletterSubscribeSteps(BaseUtil base) {
		this.base = base;
	}

	@When("^User navigated to NEWSLETTER and enteres his email as \"([^\"]*)\"$")
	public void user_navigated_to_NEWSLETTER_and_enteres_his_email_as(String email) {
		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement emailNewsLetterET = base.driver.findElement(By.className("et-email"));
		emailNewsLetterET.sendKeys(email);
		base.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@When("^User click inspire me button$")
	public void user_click_inspire_me_button() {

		WebElement inspireMeBtn = base.driver.findElement(By.className("submit"));
		inspireMeBtn.click();
	}

	@Then("^message should be displayed \"([^\"]*)\"$")
	public void message_should_be_displayed(String arg1) {

		base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * (new WebDriverWait(base.driver, 30)).until(new ExpectedCondition<Boolean>() {
		 * public Boolean apply(WebDriver drive) { return
		 * base.driver.findElement(By.className("submitted")).getText().length() != 0; }
		 * });
		 */
		String submittedMsgAR = base.driver.findElement(By.className("submitted")).getText();
		String submittedMsgER = "You are now checked-in!";
		Assert.assertEquals(submittedMsgER, submittedMsgAR);
	}

}
