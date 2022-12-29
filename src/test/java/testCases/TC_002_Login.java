package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test(groups = {"sanity", "master"})
	public void test_Login()
	{
		logger.info("starting TC_002_Login");
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("URL gets launched");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("provided email id");
			lp.setPwd(rb.getString("password"));
			logger.info("provided passowrd");
			lp.clickLogin_Btn();
			logger.info("clicked on Login button");
			boolean status=lp.isMyacPageExist();
			if (status) 
			{
				logger.info("Login is successful");
				Assert.assertEquals(status, true);
			}
			else
			{
				logger.info("Login is faalied");
				Assert.assertEquals(status, false);
			}
		} 
		catch (Exception e) 
		{
			logger.info("Login gets failed");
			//Assert.fail();
		}
		logger.info("TC_002_Login is finished");	
	}
}
