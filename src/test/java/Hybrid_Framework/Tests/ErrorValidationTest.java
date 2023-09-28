package Hybrid_Framework.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import HybridFramework_Pageobjects.CartPage;
import HybridFramework_Pageobjects.ProductCataloge;
import Hybrid_Framework.TestComponents.BaseTest;
import Hybrid_Framework.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = {"ErrorValidation"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

		String productname = "ZARA COAT 3";
		ProductCataloge productcat = lp.loginApplication("maheh@gmail.com", "Mahh@123");
		//  div[aria-label='Incorrect email or password.']
		
		Assert.assertEquals("Incorrect ema or password.", lp.getErrorMessage());
		
		
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productname = "ZARA COAT 3";
		
		//LandingPage lp = launchApplication();
		ProductCataloge productcat = lp.loginApplication("bvvmahesh@gmail.com", "Mahesh@123");
		List<WebElement> products = productcat.getProductList();
		productcat.addProductToCart(productname);
		CartPage cp = productcat.goToCartPage();
		// CartPage cp = new CartPage(driver);
		Boolean match = cp.verifyProductsDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		

		
	}
	

	}


