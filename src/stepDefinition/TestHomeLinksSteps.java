package stepDefinition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestHomeLinksSteps extends BaseUtil {

	private BaseUtil base;
	int linksCount;

	public TestHomeLinksSteps(BaseUtil base) {
		this.base = base;
	}

	@When("^System navigate to all links$")
	public void system_navigate_to_all_links() {

		String homePage = "https://magazine.trivago.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		linksCount = 0;

		List<WebElement> links = base.driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			System.out.println(url);
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					linksCount++;
					// base.driver.navigate().to(url);
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Then("^Verify that count of links is equals to \"([^\"]*)\"$")
	public void verify_that_count_of_links_is_equals_to(String countER) {
		String countAR = String.valueOf(linksCount);
		Assert.assertEquals(countER, countAR);
	}

}
