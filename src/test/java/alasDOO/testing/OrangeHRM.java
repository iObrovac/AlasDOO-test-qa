package alasDOO.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
	
	@Test
	void orangeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		// go to orange page
		driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
		//click the login button
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		//go to recruitment
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		Thread.sleep(3000);
		//click on candidates 
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		Thread.sleep(5000);
		//scroll down
		
		// switch to iFrame's context
		driver.switchTo().frame("noncoreIframe");
		
		js.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(3000);
		js.executeScript("scroll(0,2000)");

		
		
		
		// get the number of candidates 
		List<WebElement> candidates = driver.findElements(By.cssSelector("tr[class*='dataDefaultRaw dataRaw handCuser']"));
		// print the current number of candidates
		System.out.println("Number of candidates: " + candidates.size());
		
		// click on the green add button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[7]/div/div[1]/a/i")).click();
		Thread.sleep(5000);
		
		// get out of iFrame's context
		//driver.switchTo().defaultContent();
	    
		// enter first name 
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("QA Automation");
		// enter last name
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("Testing");
		// enter email address
		driver.findElement(By.id("addCandidate_email")).sendKeys("qa@wrongmail.com");
		
		// send resume to the resume field
		String userDir = System.getProperty("user.dir");
		driver.findElement(By.id("addCandidate_resume")).sendKeys(userDir + "\\Server\\Igor Obrovac - CV.pdf");
		Thread.sleep(2000);
		
		
		// select the vacancy 
		
		WebElement select = driver.findElement(By.id("add-candidate-vacancy-widget-container")); 
		select.click();
		
		
		// select the first item in the dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[2]/form/div[5]/div[1]/div/div/ul/div/li[2]/a")).click();
		Thread.sleep(2000);
		// click save 
		driver.findElement(By.id("saveCandidateButton")).click();
		Thread.sleep(3000);
		
		
		List<WebElement> candidates2 = driver.findElements(By.cssSelector("tr[class*='dataDefaultRaw dataRaw handCuser']"));
		
		System.out.println("Number of candidates: " + candidates2.size());
		
		// assert if the number of candidates increased by one 
		assertEquals(candidates.size() + 1, candidates2.size());
		
		Thread.sleep(2000);
		// select the candidate
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[7]/div/div[2]/table/tbody/tr[1]/td[1]/label")).click();
		Thread.sleep(2000);
		// click on three dots
		driver.findElement(By.id("ohrmList_Menu")).click();
		Thread.sleep(2000);
		// click on delete 
		driver.findElement(By.id("deleteItemBtn")).click();
		Thread.sleep(2000);
		//confirm deletion 
		driver.findElement(By.id("candidate-delete-button")).click();
		Thread.sleep(3000);
		// assert the number of candidates decreased by 1 
		List<WebElement> candidates3 = driver.findElements(By.cssSelector("tr[class*='dataDefaultRaw dataRaw handCuser']"));
		assertEquals(candidates2.size() - 1, candidates3.size());
		System.out.println("Number of candidates: " + candidates3.size());
		// click on the HR icon 
		driver.findElement(By.id("account-job")).click();
		Thread.sleep(2000);
		// click on logout 
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
}
