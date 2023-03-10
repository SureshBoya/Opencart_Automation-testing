package testCases;

import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_ForgotPassword extends BaseClass
{
	@Test
	public void forgotpwd()
	{
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			ForgotPassword fp=new ForgotPassword(driver);
			fp.clickOnForgotPwd();
			fp.clickOnForgotPwdfield(rb.getString("email"));
			fp.clickOnContinueButton();
			String status=fp.alert_msg_for_ForgotPwd();
			System.out.println(status);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
}
