package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider = "login")
	public void test_Login(String email,String pwd,String exp)
	{
		logger.info("TC_003_LoginDataDrivenTest started");
		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info("app url gets launched");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on My Account");
			
			hp.clickLogin();
			logger.info("clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			logger.info("Provided email");
			
			lp.setPwd(pwd);
			logger.info("Provided pwd ");
			
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			boolean status=lp.isMyacPageExist();
			
			if(exp.equals("valid"))
			{
				if (status==true) 
				{
					logger.info("Login is successful for valid credentials");
					MyAccountPage ma=new MyAccountPage(driver);
					ma.clickLogoutButton();
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("Login is failed");
					Assert.assertTrue(false);
				}
			}
			else if (exp.equals("invalid")) 
			{
				if (status==true) 
				{
					logger.info("Login is failed for invalid credentials ");
					MyAccountPage ma=new MyAccountPage(driver);
					ma.clickLogoutButton();
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("Login is failed");
					Assert.assertTrue(true);
				}
			}	
		} 
		catch (Exception e) 
		{
			logger.info("Login is failed");
			//Assert.fail();
		}	
	}
	@DataProvider(name="login")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\datadriven.xlsx";
		XLUtility xl=new XLUtility(path);
		int row=xl.getRowCount("sheet1");
		int cell=xl.getCellCount("sheet1", 1);
		
		String logindata[][]=new String[row][cell];
		
		for(int r=1;r<=row; r++)
		{
			for(int c=0;c<cell;c++)
			{
				logindata[r-1][c]=xl.getCellData("sheet1", r, c);
			}
		}
		return logindata;
	}
}
