package HybridFramework_Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Hybrid_AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
    
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkOutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProductNames;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']//h3"));
	
	//Boolean match = cartProducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
	//Assert.assertTrue(match);
	
	//driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	
	

	public boolean verifyOrderDisplay(String productname) {
		// TODO Auto-generated method stub
		Boolean match = orderProductNames.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	
	

}
