package testCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductCompare;
import pageObjects.ProductDisplay;
import testBase.BaseClass;

public class TC_007_ProductDisplay extends BaseClass
{
	//iMac product
	@Test
	public void iMac_ProductDisplay() throws AWTException, InterruptedException
	{
		try 
		{
			logger.info("TC_007_ProductDisplay is started");
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("password"));
			lp.clickLogin_Btn();
			
			ProductCompare pc=new ProductCompare(driver);
			pc.desktops();
			
			ProductDisplay pd=new ProductDisplay(driver);
			pd.lnkMacPdt();
			pd.iMac_img_srhrst();
			pd.iMacThumbnail();
			pd.rightArrow_iMac_img();
			pd.iMac_pdt_title();
			pd.iMac_BrandName();
			pd.iMac_pdt();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
}