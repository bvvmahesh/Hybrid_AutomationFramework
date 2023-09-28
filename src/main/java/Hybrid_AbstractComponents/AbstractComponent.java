package Hybrid_AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HybridFramework_Pageobjects.CartPage;
import HybridFramework_Pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersHeader;

	
	//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	
	public void waitForElementToAppear(By findBy) 
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy) 
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrdersPage goToordersHeader()
	{
		ordersHeader.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
		
	}
	
	public void waitForElementToDissapear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
