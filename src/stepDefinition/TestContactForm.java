package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestContactForm extends BaseUtil {

	private BaseUtil base;

	public TestContactForm(BaseUtil base) {
		this.base = base;
	}

	@Given("^User Navigated to contact page$")
	public void user_Navigated_to_contact_page() {

		// base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebElement contactLink = base.driver.findElement(By.linkText("Contact"));
		// contactLink.click();

		base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement contactLink = base.driver.findElement(By.linkText("Contact"));
		JavascriptExecutor jse2 = (JavascriptExecutor) base.driver;
		jse2.executeScript("arguments[0].scrollIntoView()", contactLink);
		contactLink.click();

	}

	@When("^User enters the name \"([^\"]*)\" and the email \"([^\"]*)\" and message \"([^\"]*)\"$")
	public void user_enters_the_name_and_the_email_and_message(String name, String email, String message) {
		// WebDriverWait wait = new WebDriverWait(base.driver, 30);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("contact-msg")));
		// base.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		WebElement contactEmail = base.driver.findElement(By.id("contact-email"));
		contactEmail.sendKeys(email);
		
		WebElement contactMsg = (new WebDriverWait(base.driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("contact-msg")));
//		WebElement contactMsg = base.driver.findElement(By.className("contact-msg"));
		contactMsg.sendKeys(message);

		WebElement contactName = base.driver.findElement(By.className("contact-input"));
		contactName.sendKeys(name);

//		WebElement contactEmail = base.driver.findElement(By.id("contact-email"));
//		contactEmail.sendKeys(email);

	}

	@When("^User confirm the checkbox to click submit$")
	public void user_confirm_the_checkbox_to_click_submit() {

	}

	@Then("^User message should sent successfully$")
	public void user_message_should_sent_successfully() {

	}

}
