package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExportDataPage {

	public WebDriver driver;
	By excel_loacator = By.id("excel");
	By jobcode_locator = By.id("ExportFileFields][jobCode]");
	By clientManger_locator = By.xpath("//input[@value='client_manager']");
	By primarySkills_locator = By.id("ExportFileFields][configTechnologyId]");
	By accountManager_locator = By.id("ExportFileFields][accountManager]");
	By jobStartDate_locator = By.id("ExportFileFields][jobStartDate]");
	By JobEndDate_locator = By.id("ExportFileFields][jobEndDate]");
	By industry_locator = By.id("ExportFileFields][industryExp]");
	By areaCode_locator = By.id("ExportFileFields][areaCode]");
	By jobType_locator = By.id("ExportFileFields][jobType]");
	By jobAge_locator = By.id("ExportFileFields][jobAge]");

	By exportbtn_locator = By.xpath("//button[text()='Export ']");
	By custom1_locator = By.xpath("//*[@id='export_files_multi']/tr[1]/td[1]/a/i");
	By cancel_locator = By.xpath("//*[@id='export_block_2']/div[3]/button[2]");

	public ExportDataPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickExcelButton() {
		driver.findElement(excel_loacator).click();
	}

	public void clickJobCode() {
		driver.findElement(jobcode_locator).click();
	}

	public void clickClientManager() {
		driver.findElement(clientManger_locator);
	}

	public void clickPrimarySkills() {
		driver.findElement(primarySkills_locator).click();
	}

	public void clickAccountManger() {
		driver.findElement(accountManager_locator).click();
	}

	public void clickJobStartDate() {
		driver.findElement(jobStartDate_locator).click();
	}

	public void clickJobEnddate() {
		driver.findElement(JobEndDate_locator).click();
	}

	public void clickIndustry() {
		driver.findElement(industry_locator).click();
	}

	public void clickAreaCode() {
		driver.findElement(areaCode_locator).click();
	}

	public void ClickJobType() {
		driver.findElement(jobType_locator).click();
	}

	public void ClickJobAge() {
		driver.findElement(jobAge_locator).click();
	}

	public void clickExportButton() {
		driver.findElement(exportbtn_locator).click();
	}

	public void clickCustom1() {
		driver.findElement(custom1_locator).click();
	}

	public JobPostingPage clickCancelbutton() {
		driver.findElement(cancel_locator).click();
		return new JobPostingPage(driver);
	}

}
