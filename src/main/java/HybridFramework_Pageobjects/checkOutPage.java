package HybridFramework_Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Hybrid_AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent	
{

	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions a = new Actions(driver);
	//a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
	//driver.findElement(By.xpath("(//span[contains(text(),'India')])[2]")).click();
	//driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click();
	
	//String ActualMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	//System.out.println(ActualMessage);
	//Assert.assertTrue(ActualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	//driver.close();
		
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//span[contains(text(),'India')])[2]")
	WebElement selectCountry;
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
}
