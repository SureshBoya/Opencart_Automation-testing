package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountHomePage;
import testBase.BaseClass;

public class TC_013_MyAccount extends BaseClass
{
	@Test(priority = 1)
	public void MyAccount()
	{
		logger.info("TC_013_MyAccount is started");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("password"));
			lp.clickLogin_Btn();
			
			hp.clickMyAccount();
			MyAccountHomePage map=new MyAccountHomePage(driver);
			map.clk_MyAccount();
			Thread.sleep(10000);
			String act_title=driver.getTitle();
			String exp_title=map.title_MyAccount();
			if (exp_title.equals(exp_title)) 
			{
				logger.info("My Account title is displayed");
				Assert.assertTrue(true);
			} 
			else 
			{
				logger.error("My Account page is Failed ");
				captureScreen(driver, "test_My Account home page"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("My Account Home page is Failed ");
			Assert.assertTrue(false);
		}
		
		logger.info("TC_013_MyAccount is completed");
	}
}
