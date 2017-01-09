package yakisuzu;

import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.collections.SizeGreaterThan;

/**
 *
 */
public class App {
	static {
		Configuration.reportsFolder = "reports";
		Configuration.browser = WebDriverRunner.CHROME;
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
	}

	public static void main(String[] args) {
		Selenide.open("https://www.google.co.jp/");
		Selenide.$(By.id("lst-ib")).setValue("twitter").pressEnter();
		Selenide.$$(By.tagName("h3")).shouldHave(new SizeGreaterThan(0)).forEach((e) -> {
			System.out.println(e);
		});
		Selenide.screenshot("sc_twitter");
	}
}
