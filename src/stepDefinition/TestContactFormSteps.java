package stepDefinition;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestContactFormSteps extends BaseUtil {

	private BaseUtil base;

	public TestContactFormSteps(BaseUtil base) {
		this.base = base;
	}

	@Given("^User Navigated to contact page$")
	public void user_Navigated_to_contact_page() {

		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement contactLink = base.driver.findElement(By.linkText("Contact"));
		JavascriptExecutor jse2 = (JavascriptExecutor) base.driver;
		jse2.executeScript("arguments[0].scrollIntoView()", contactLink);
		contactLink.click();

		ArrayList<String> tabs2 = new ArrayList<String>(base.driver.getWindowHandles());
		base.driver.switchTo().window(tabs2.get(1));

	}

	@When("^User enters the name \"([^\"]*)\" and the email \"([^\"]*)\" and message \"([^\"]*)\"$")
	public void user_enters_the_name_and_the_email_and_message(String name, String email, String message) {

		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement contactMsg = base.driver.findElement(By.className("contact-msg"));
		contactMsg.sendKeys(message);

		WebElement contactName = base.driver.findElement(By.className("contact-input"));
		contactName.sendKeys(name);

		WebElement contactEmail = base.driver.findElement(By.id("contact-email"));
		contactEmail.sendKeys(email);

	}

	@When("^User confirm the checkbox to click submit$")
	public void user_confirm_the_checkbox_to_click_submit() {
		WebElement confirmCB = base.driver.findElement(By.id("confirm"));
		confirmCB.click();

		WebElement submitBtn = base.driver.findElement(By.className("contact-submit"));
		submitBtn.click();
	}

	@Then("^User message should sent successfully$")
	public void user_message_should_sent_successfully() {

		String feedbackMsgAR = base.driver.findElement(By.className("feedback")).getText();
		String feedbackMsgER = "Message Sent Successfully!";
		Assert.assertEquals(feedbackMsgER, feedbackMsgAR);

	}

}
