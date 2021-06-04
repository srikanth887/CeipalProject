package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\srika\\eclipse-workspace\\Com.Ceipal\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	
	//driver= new ChromeDriver();
		//execute in chrome driver
	
//	ChromeOptions options = new ChromeOptions();

	/*String downloadFilepath = "/path/to/download";
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadFilepath);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", chromePrefs);
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	cap.setCapability(ChromeOptions.CAPABILITY, options);
	 driver = new ChromeDriver(cap);*/
	
	String downloadFilepath = "C:\\Users\\srika\\OneDrive\\Documents";
	/*HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadFilepath);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", chromePrefs);
	 driver = new ChromeDriver(options);*/
	
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
	 chromePrefs.put("profile.default_content_settings.popups", 0);  
	 chromePrefs.put("download.default_directory", downloadFilepath);  
	 ChromeOptions options = new ChromeOptions();  
	 options.setExperimentalOption("prefs", chromePrefs);  
	 options.addArguments("--disable-notifications");  
	 DesiredCapabilities cap = DesiredCapabilities.chrome();  
	 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
	 cap.setCapability(ChromeOptions.CAPABILITY, options);  
	 //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe"); 
	 System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	 driver = new ChromeDriver(options);  
	 driver.manage().window().maximize();
}
else if (browserName.equals("firefox"))
{
	// driver= new FirefoxDriver();
	//firefox code
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\ghs6kor\\Desktop\\Java\\geckodriver.exe");
     // create object of FirefoxOptions class
     FirefoxOptions profile = new FirefoxOptions();
     // adding browser preferences with addPreference method
     profile.addPreference("browser.download.folderList", 2);
     // location of downloaded file
     profile.addPreference("browser.download.dir", "C:\\Users\\ghs6kor\\Documents\\Download");
     profile.addPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/x-msexcel,application/excel," + "application/x-excel,application/vnd.ms-excel," + "image/png,image/jpeg,text/html,text/plain," + "application/msword,application/xml");
     profile.addPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel," + "application/excel," + "application/x-excel," +"application/vnd.ms- excel,image/png,image/jpeg,text/html," +"text/plain,application/msword,application/xml");
     profile.addPreference("browser.helperApps.alwaysAsk.force", false);
     profile.addPreference
     ("browser.download.manager.alertOnEXEOpen", false);
     profile.addPreference("browser.download.manager.focusWhenStarting", false);
     profile.addPreference("browser.download.manager.useWindow", false);
     profile.addPreference("browser.download.manager.showAlertOnComplete", false);
     profile.addPreference("browser.download.manager.closeWhenDone", false);
     // connecting browser options to webdriver
      driver = new FirefoxDriver(profile);
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
