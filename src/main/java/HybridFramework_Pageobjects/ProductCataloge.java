package HybridFramework_Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hybrid_AbstractComponents.AbstractComponent;

public class ProductCataloge extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCataloge(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}

	// List<WebElement> products  = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.xpath("//div[contains(@class,'mb-3')]");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		return  prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addtocart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDissapear(spinner);
		
	}
	
	

}
