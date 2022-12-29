package testCases;

import org.testng.annotations.Test;

import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_012_CheckOut extends BaseClass
{
	@Test(priority = 1)
	public void checkOut_WithOutPDTs()
	{
		logger.info("TC_012_CheckOut is started");
		try 
		{
			// no pdts are added in the SC
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("pwd"));
			lp.clickLogin_Btn();
			hp.clk_Header_Checkout();
			CheckOutPage cp=new CheckOutPage(driver);
			cp.title_SC_clk_Chechout();
		} 
		catch (Exception e) 
		{
			logger.fatal("Checkout is Failed if no products are prasent");
		}
	
	}
	
	@Test(priority = 2)
	public void checkOut_WithPDTs_existingadd() throws InterruptedException
	{
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("pwd"));
			lp.clickLogin_Btn();
			
			CheckOutPage cp=new CheckOutPage(driver);
			cp.wishList_Header();
			cp.clk_AddToCart();
			hp.clk_Header_Checkout();
			cp.title_Checkout_Vali();
			cp.clk_Chkbox_existing_Payment();
			cp.select_add();
			cp.clk_Chkbox_existing_Shipping();
			cp.select_shippingmethod();
			cp.shipping_msg_validation();
			cp.select_payment();
			cp.payment_msg_validation();
			cp.clk_Comment();
			cp.clk_ConfirmOrder();
			cp.oderPlaced_validation();
			Thread.sleep(10000);
			cp.clk_History_inOrderPlaced();
			cp.clk_Continue_OrderPlaced();	
		} 
		catch (Exception e) 
		{
			logger.fatal("Checkout is Failed if products are prasent and existing address selected");
		}
		
	}
	@Test(priority = 3)
	public void chekOut_newAd_payment() throws InterruptedException
	{
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("pwd"));
			lp.clickLogin_Btn();
			
			CheckOutPage cp=new CheckOutPage(driver);
			cp.wishList_Header();
			cp.clk_AddToCart();
			hp.clk_Header_Checkout();
			cp.clk_newAdd_Payment();
			cp.clk_FirstName_Payment();
			cp.clk_LastName_payment();
			cp.clk_Company_payment();
			cp.clk_Addr1_payment();
			cp.clk_Addr2_payment();
			cp.clk_City_payment();
			cp.clk_Postcode_payment();
			cp.clk_Country_Payment();
			cp.clk_Zone_Payment();
			cp.clk_Continue_payment();
			cp.clk_Chkbox_existing_Shipping();
			cp.select_shippingmethod();
			cp.shipping_msg_validation();
			cp.select_payment();
			cp.payment_msg_validation();
			cp.clk_Comment();
			cp.clk_ConfirmOrder();
			cp.oderPlaced_validation();
			Thread.sleep(10000);
			cp.clk_History_inOrderPlaced();
			cp.clk_Continue_OrderPlaced();
		} 
		catch (Exception e) 
		{
			logger.fatal("Checkout is Failed if products are prasent, new payment address selected");
		}
		
	}
	@Test(priority = 4)
	public void checkout_newAddr_Shipping() throws InterruptedException
	{
		try 
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPwd(rb.getString("pwd"));
			lp.clickLogin_Btn();
			
			CheckOutPage cp=new CheckOutPage(driver);
			cp.wishList_Header();
			cp.clk_AddToCart();
			hp.clk_Header_Checkout();
			cp.clk_newAddr_Shipping();
			cp.clk_Firstname_Shipping();
			cp.clk_Lastname_Shipping();
			cp.clk_Company_shipping();
			cp.clk_Addr1_Shipping();
			cp.clk_Addr2_Shipping();
			cp.clk_City_Shipping();
			cp.clk_Postcode_Shipping();
			cp.country_Shipping();
			cp.zone_Shipping();
			cp.clk_Continue_Shipping();
			cp.select_payment();
			cp.payment_msg_validation();
			cp.clk_Comment();
			cp.clk_ConfirmOrder();
			cp.oderPlaced_validation();
			Thread.sleep(10000);
			cp.clk_History_inOrderPlaced();
			cp.clk_Continue_OrderPlaced();	
		}
		catch (Exception e) 
		{
			logger.fatal("Checkout is Failed if products are prasent, new Shipping address selected");
		}
	}
}
