package alasDOO.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheeseQA {

	@Test
	void tooMuchCheese() {
		System.setProperty("webdriver.chrome.driver", "Server\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.manage().window().maximize();
		// go to google
		driver.get("http://www.google.com");
		// select the search field and type cheese
		driver.findElement(By.name("q")).sendKeys("cheese");
		// hit enter
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		// compare the number of results
		String actual = driver.findElement(By.id("result-stats")).getText();
		String expected = "777";
		assertEquals(actual, expected, "There is too much cheese on the internet!");
		}
}
