package testCases;

import org.testng.annotations.Test;

import pageObjects.AddToCart;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_008_AddToCart extends BaseClass
{
	@Test
	public void pdt_AddToCart() throws InterruptedException
	{
		try 
		{
			logger.info("TC_008_AddToCart is started");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("my account link is clicked");
			
			hp.clickLogin();
			logger.info("login link is clicked");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("email is provided");
			lp.setPwd(rb.getString("password"));
			logger.info("Password is provided");
			lp.clickLogin_Btn();
			
			AddToCart ac=new AddToCart(driver);
			ac.pdt_HTC_SC();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
}
