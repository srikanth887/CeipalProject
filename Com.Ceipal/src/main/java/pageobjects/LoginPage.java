package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	By userName=By.id("UserLoginUsername");
	By Password=By.id("UserLoginPassword");
	By signin=By.id("signin_submit");
	By noThanks=By.id("pushActionRefuse");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void enterUserName(String uName)
	{
		driver.findElement(userName).sendKeys(uName);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(Password).sendKeys(password);
	}
	
	public HomePage clickSignInButton()
	{
		driver.findElement(signin).click();
		return new  HomePage(driver);
	}
	public void clickNoThanks()
	{
		driver.findElement(noThanks).click();
		
		
	}
	
}
