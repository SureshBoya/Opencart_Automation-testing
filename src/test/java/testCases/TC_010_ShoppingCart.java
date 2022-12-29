package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCart;
import testBase.BaseClass;

public class TC_010_ShoppingCart extends BaseClass
{
	@Test(priority = 1)
	public void pdt_ShoppingCart()
	{
		logger.info("TC_010_ShoppingCart is started");
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("password"));
			lp.clickLogin_Btn();
			
			ShoppingCart sp=new ShoppingCart(driver);
			hp.clk_ShoppingCart_header();
			sp.msg_SC_noPDTs();
			sp.clk_Continue();
			sp.homePage_logo();
			
			//adding product to the ShoppingCart
			hp.clk_Desktops();
			hp.clk_Mac();
			
			sp.clk_Mac_pdt();
			sp.clk_AddToCart_PD();
			sp.msg_Afterclk_AddtocartBTN();
			
			hp.clk_ShoppingCart_header();
			sp.title_ShoppingCart();
			sp.table();
			
			//Estimate and Shipping
			sp.clk_EstimateShipping();
			sp.clk_Quote_ES_SC();
			sp.withoutfilters_msg();
			sp.clk_Country();
			sp.clk_Region();
			sp.clk_PostalCode();
			sp.clk_Quote_ES_SC();
			sp.clk_FlatShippingRate();
			sp.clk_ApplyShipping();
			sp.final_msg_ES();
			
			//Use CoupanCode
			sp.clk_UseCoupanCode();
			sp.clk_invalid_Coupan();
			sp.clk_valid_Coupan();
			
			//Gift Certificate
			sp.clk_GiftCertificate();
			sp.clk_invalid_gift();
			sp.clk_valid_Gift();
			
			//Checkout
			sp.clk_Checkout();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
