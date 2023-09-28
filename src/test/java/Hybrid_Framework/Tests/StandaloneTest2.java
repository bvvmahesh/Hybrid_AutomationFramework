package Hybrid_Framework.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HybridFramework_Pageobjects.CartPage;
import HybridFramework_Pageobjects.ConfirmationPage;
import HybridFramework_Pageobjects.OrdersPage;
import HybridFramework_Pageobjects.ProductCataloge;
import HybridFramework_Pageobjects.checkOutPage;
import Hybrid_Framework.TestComponents.BaseTest;

public class StandaloneTest2 extends BaseTest {

	String productname = "ZARA COAT 3";
	@Test(dataProvider="getData", groups = {"Purchase","Regression"})
	public void submitOrderTestCase(HashMap<String,String> input) throws IOException, InterruptedException
	{
        //LandingPage lp = launchApplication();
		ProductCataloge productcat = lp.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcat.getProductList();
		productcat.addProductToCart(input.get("product"));
		CartPage cp = productcat.goToCartPage();
		// CartPage cp = new CartPage(driver);
		Boolean match = cp.verifyProductsDisplay(input.get("product"));
		Assert.assertTrue(match);
		checkOutPage checkout = cp.goToCheckOut();
		checkout.selectCountry("India");

		ConfirmationPage confirmpage = checkout.submitOrder();

		String ConfirmMessage = confirmpage.getConfirmationMessage();
		System.out.println(ConfirmMessage);
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		
	}
	
	@Test(dependsOnMethods = {"submitOrderTestCase"})
	public void orderHistoryTest()
	{    
		ProductCataloge productcat = lp.loginApplication("bvvmahesh@gmail.com", "Mahesh@123");
		OrdersPage op = productcat.goToordersHeader();
		Assert.assertTrue(op.verifyOrderDisplay(productname));
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Hybrid_Framework\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}} ;
		
	}
	
	/* @DataProvider
	public  Object[][] getData()
	{
		return new Object[][] { {"bvvmahesh@gmail.com","Mahesh@123","ZARA COAT 3"},{"mahesh24@gmail.com","Mahesh@123","ADIDAS ORIGINAL"} };
		
		} */

//	@DataProvider
//	public Object[][] getData()
//	{
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "bvvmahesh@gmail.com");
//	map.put("password", "Mahesh@123");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "mahesh24@gmail.com");
//	map1.put("password", "Mahesh@123");
//	map1.put("product", "ADIDAS ORIGINAL");
//	return new Object[][] {{map},{map1}} ;
//	}
	
	} 



