package HybridFramework_Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Hybrid_AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	//String ActualMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	//System.out.println(ActualMessage);
	//Assert.assertTrue(ActualMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	//driver.close();
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		return confirmationMessage.getText();
	}
	
	
}
