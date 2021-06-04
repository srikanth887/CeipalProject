package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;
	
	By jobPosting_locator=By.xpath("//*[@id='navbarCollapse']/ul/li[2]/a");////*[@id="navbarCollapse"]/ul/li[2]/a
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public JobPostingPage clickJobPosting() throws Exception
	{
	 ////	JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", jobPosting_locator);
		Thread.sleep(5000);
		//driver.findElement(jobPosting_locator).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(jobPosting_locator)).click();
		return new JobPostingPage(driver);
	}
	

}
