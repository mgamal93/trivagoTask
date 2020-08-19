package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseUtil;
import cucumber.api.java.Before;

public class Hooks extends BaseUtil {

	private BaseUtil base;

	public Hooks(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void initializeTest() {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	}

}
