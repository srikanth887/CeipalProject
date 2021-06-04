
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.ExportDataPage;
import pageobjects.HomePage;
import pageobjects.JobPostingPage;
import pageobjects.LoginPage;

import resources.Base;

public class Download_Excel extends Base {
	private static final String Null = null;
	public WebDriver driver;
	String userName = "spanjwani@infinite-usa.com";
	String Password = "Love@5523";

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
	

		driver = initializeDriver();
		

	}

	@Test

	public void Login() throws IOException, Exception {

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.clickNoThanks();
		Thread.sleep(5000);
		System.out.println(userName);
		lp.enterUserName(userName);
		// Thread.sleep(5000);
		lp.enterPassword(Password);
		// Naviagte to home page
		HomePage hp = lp.clickSignInButton();
		Thread.sleep(5000);
		// Navigate to job posting page

		JobPostingPage jp = hp.clickJobPosting();
		Thread.sleep(5000);
		// Naviagte to export popup page or popup
		ExportDataPage ed = jp.clickexportBtn();
		ed.clickExcelButton();
		// ed.clickJobCode();
		ed.clickAccountManger();
		ed.clickPrimarySkills();
		ed.clickAccountManger();
		ed.clickJobStartDate();
		ed.clickJobEnddate();
		ed.clickIndustry();
		ed.clickAreaCode();
		Thread.sleep(2000);
		ed.ClickJobType();
		ed.ClickJobAge();
		ed.clickExportButton();
		ed.clickCustom1();
		ed.clickCancelbutton();
		jp.clickAnydropdown();
		jp.clickClientJobId();
		readExcelData();

	}

	@AfterTest
	public void teardown() {

		// driver.close();

	}

	public void readExcelData() throws Exception {
		String path = checkFile("Custom-2021-06-02.xlsx");
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Worksheet");
		XSSFRow row = sheet.getRow(1);
		// System.out.println(sheet);
		// System.out.println(row);

		int col_num = -1;
		System.out.println(row.getLastCellNum());

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().equals("Client Job ID"))
				col_num = i;

		}
		System.out.println(sheet.getLastRowNum());
		for (int j = 2; j <= sheet.getLastRowNum(); j++) {
			row = sheet.getRow(j);
			XSSFCell cell = row.getCell(col_num);
			
			try {
 				String clientJobId = cell.getStringCellValue();
				
				enterClientJobId(clientJobId);

				String noofs = getSubmissionValue();
				System.out.println(noofs);
				XSSFCell cellsubh = sheet.getRow(1).createCell(11);
				cellsubh.setCellValue("Submission values");
				XSSFCell cellsub = sheet.getRow(j).createCell(11);
				cellsub.setCellValue(noofs);
				// writing data no of submisions into excel
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
	 			clearClientJobId();
	 			

				System.out.println("Value of the Excel Cell is - " + clientJobId);
				
			} catch (Exception e) {
				// TODO: handle exception
				String noofs=null;
				XSSFCell cellsub = sheet.getRow(j).createCell(11);
				cellsub.setCellValue(noofs);
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
			}
			
		}
			
			
		workbook.close();
		// close the work book
		
	}

	public void enterClientJobId(String JobId) {
		driver.findElement(By.id("keyword")).sendKeys(JobId);
		driver.findElement(By.id("keyword")).sendKeys(Keys.ENTER);
		// driver.findElement(By.id("keyword")).clear();

	}

	public String getSubmissionValue() {
		try {
			String noOfSumbmissions = driver.findElement(By.xpath("//div[@data-original-title='Submissions']"))
					.getText();
			return noOfSumbmissions;

		} catch (Exception e) {
			// TODO: handle exception
			return Null;
		}

		// WebElement
		// submissions=driver.findElement(By.xpath("//div[@data-original-title='Submissions']"));
		/*
		 * if(driver.findElement(By.xpath("//div[@data-original-title='Submissions']")).
		 * isDisplayed()) { String noOfSumbmissions=driver.findElement(By.xpath(
		 * "//div[@data-original-title='Submissions']")).getText(); return
		 * noOfSumbmissions; }else { return Null; }
		 */
	}

	public void clearClientJobId() {
		driver.findElement(By.id("keyword")).clear();
	}
	public String  checkFile(String filename)

	{
	    //String home = System.getProperty("user.home");
	    String file_name = filename;
	    String file_with_location = "C:\\Users\\srika\\OneDrive\\Documents\\" + file_name;
	    System.out.println(file_with_location);
	    File file = new File(file_with_location);
	    if (file.exists()) {
	        System.out.println(file_with_location + " is present");
	        
	    }
	        else {
	        System.out.println(file_with_location + " is not present");
	    }
		return file_with_location;
	}

}
