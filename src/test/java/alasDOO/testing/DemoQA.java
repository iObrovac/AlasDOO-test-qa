package alasDOO.testing;



import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class DemoQA {
	
	@Disabled
	@Test
	void testDemoQA() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		// navigate to google
		driver.get("http://www.google.com");
		
		// select the search bar and type the address
		driver.findElement(By.name("q")).sendKeys("demoqa.com");
		// take it easy 
		Thread.sleep(2000);
		// press enter to search 
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		// wait till the first element is clickable and then click it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"))).click();
		                                                         
		
		Thread.sleep(2000);
		
		// find the interactions button and click it
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[5]/div/div[1]")).click();
		
		Thread.sleep(2000);
		// scroll to the bottom of the page
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		
		// click on droppable
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[4]")).click();
		
		Thread.sleep(2000);
		//move the element to the box
		WebElement fromEl = driver.findElement(By.id("draggable"));
		WebElement toEl = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(fromEl).moveToElement(toEl).release(toEl).build();
		dragAndDrop.perform();
		
		// print out the text from the drop box
		System.out.println(toEl.getText());
		Thread.sleep(2000);
		// take the screenshot of the page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\Screen.jpeg");
		FileUtils.copyFile(source, destFile);
		System.out.println("The Screenshot is taken");
		
		//click on widgets
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div")).click();
		Thread.sleep(3000);
		// scroll down 
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		
		//remove the commercial 
		//driver.findElement(By.xpath("/html/body/div[3]/form/label/svg/path[2]")).click();
		
		// click on Tool Tips
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[7]/span")).click();
		
		// hover the "hover me to see" button
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("toolTipButton"))).build().perform();
		Thread.sleep(1000);
		
		// take the message that appears on hover and print it to console
		String msg = driver.findElement(By.className("tooltip-inner")).getText();
		System.out.println(msg);
		
		Thread.sleep(3000);
		driver.close();
		}
	
		
		

}
 