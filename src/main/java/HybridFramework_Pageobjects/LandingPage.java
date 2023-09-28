package HybridFramework_Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hybrid_AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@id='userEmail']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;
	
	// @FindBy(css="[class*='flyout']")
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public ProductCataloge loginApplication(String loginname, String loginpassword)
	{
		username.sendKeys(loginname);
		password.sendKeys(loginpassword);
		submit.click();
		ProductCataloge productcat = new ProductCataloge(driver);
		return productcat;
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		 
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
