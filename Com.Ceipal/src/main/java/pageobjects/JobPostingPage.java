package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class JobPostingPage {
           public WebDriver driver;
           
           By export_locator=By.xpath("//a[@class='export_fields_selctn']");
           By anydropDown_locator=By.xpath("//*[@id='Job_Posting_Form']/div/a");
           By clientJobId_locator=By.xpath("//a[text()='Client Job ID']");
           
           public JobPostingPage(WebDriver driver) {
       		// TODO Auto-generated constructor stub
       		this.driver=driver;
       	}
           public ExportDataPage clickexportBtn()
           {
        	   driver.findElement(export_locator).click();
        	   return new ExportDataPage(driver);
           }
           public void clickAnydropdown()
           {
        	   driver.findElement(anydropDown_locator).click();
           }
           public void clickClientJobId()
           {
        	 /*  Actions act=new Actions(driver);
        	   act.click(driver.findElement(clientJobId_locator));*/
        	   driver.findElement(clientJobId_locator).click();
           }
           
           


	


}
