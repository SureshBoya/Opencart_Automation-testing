package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductCompare;
import testBase.BaseClass;

public class TC_006_ProductCompare extends BaseClass
{
	//when no products are added
	@Test(priority = 1)
/*	public void zeroPdt()
	{
		logger.info("TC_006_ProductCompare is started");
		driver.get(rb.getString("appURL"));
		logger.info("url of the app gets launched");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		
		hp.clickLogin();
		logger.info("clicked on login page");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("given mail id");
		
		lp.setPwd(rb.getString("password"));
		logger.info("given pwd");
		
		lp.clickLogin();
		logger.info("Clicked on Login button");
		
		ProductCompare pc=new ProductCompare(driver);
		pc.desktops();
		logger.info("clicked on desktop option");
		
		pc.showAllDesktops();
		logger.info("clicked on show all desktops option");
		
		pc.productCompareNo();
		logger.info("clicked on product comapre link");
		//pc.prdtCmpMsgWhen0prdt();
		//pc.prdtCmpMsgWhen0prdt();
		pc.buttonContinue();
		pc.homePageTitle();
	} */
	
	public void pdtcmpWithProduct() throws InterruptedException
	{
		try 
		{
			logger.info("TC_006_Product compare is started");
			driver.get(rb.getString("appURL"));
			logger.info("app url gets launched");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on my account");
			
			hp.clickLogin();
			logger.info("clicked on login link");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("provided email id");
			
			lp.setPwd(rb.getString("password"));
			logger.info("provided password field");
			
			lp.clickLogin_Btn();
			logger.info("clicked on login button");
			ProductCompare pc=new ProductCompare(driver);
			pc.desktops();
			logger.info("clicked on desktops");
			pc.showAllDesktops();
			Thread.sleep(20000);
			pc.cannon();
			Thread.sleep(2000);
			pc.productApple();
			Thread.sleep(2000);
			pc.msgAfterClickingProductCompare();
			pc.productCompareNo();
			logger.info("clicked on product comparision link");
			
			Thread.sleep(2000);
		
			pc.addToCart();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
