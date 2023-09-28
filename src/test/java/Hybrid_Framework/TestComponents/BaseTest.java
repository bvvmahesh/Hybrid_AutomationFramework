package Hybrid_Framework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import HybridFramework_Pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver intializeDriver() throws IOException
	{
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Hybrid_Framework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
		   driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("internetexplorer"))
		{
			
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String jsonFilePath) throws IOException
	{
		//read json to string
	
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),
				StandardCharsets.UTF_8); 
		
		//String to HashMap Jackson Datbind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap <String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap< String,String>>>() {
		});
		return data;
		}
	
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		// we need to cast our driver object to TakesScreenshot Interface
		TakesScreenshot ts  = (TakesScreenshot)driver;
		// we need to get the screenshot in file format
		File source = ts.getScreenshotAs(OutputType.FILE);
		// we need to copy the file in local workspace
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png"  );
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver =  intializeDriver();
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
}
