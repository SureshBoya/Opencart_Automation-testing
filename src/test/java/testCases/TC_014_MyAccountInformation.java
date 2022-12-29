package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInformation;
import testBase.BaseClass;

public class TC_014_MyAccountInformation extends BaseClass
{
	@Test
	public void MyAccountInformationn()
	{
		logger.info("TC_014_MyAccountInformation is started");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("password"));
			lp.clickLogin_Btn();
			
			MyAccountInformation mai=new MyAccountInformation(driver);
			mai.clk_MyAccount_drp();
			mai.clk_MyAccount_menu();
			boolean title=mai.title_MyAccountInformation();
			if (title)
			{
				Assert.assertTrue(title);
			} 
			else 
			{
				Assert.assertTrue(false);
			}
			mai.set_FirstName();
			mai.set_LastName();
			mai.set_Email();
			mai.clk_Continue();
			String msg_error=mai.error_msg();
			if (msg_error.equals("E-Mail Address does not appear to be valid!")) 
			{
				Assert.assertTrue(true);
			} 
			else {
				Assert.assertTrue(false);
			}
			mai.btn_Back();
			String Myaccount_Title=mai.title_MyAccount();
			if (Myaccount_Title.equals(driver.getTitle())) 
			{
				Assert.assertTrue(true);
			}
			else 
			{
				captureScreen(driver, "My Account Information Page"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		} 
		catch (Exception e)
		{
			//Assert.fail();
		}
	}
}
