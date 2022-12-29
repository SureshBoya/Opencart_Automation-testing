package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WishList;
import testBase.BaseClass;

public class TC_009_WishList extends BaseClass
{
	//my account -> WishList -> If no products are added
	public void comman()
	{
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
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	
	}
	
	
	@Test(priority = 1)
	public void wishList_if_no_pdts() throws InterruptedException
	{
		try 
		{
			comman();
			WishList wl=new WishList(driver);
			wl.clk_MyAccount_lnk();
			wl.title_Myaccount();
			wl.clk_ModifyUrWishList();
			wl.title_MyWishList();
			wl.msg_inWL();
			wl.clk_continue_btn();
			Thread.sleep(10000);
			wl.title_Myaccount();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

	}
	
	//From product display page to WishList page
	@Test(priority = 2)
	public void pdtDisplay_to_WL()
	{
		try 
		{
			comman();
			
			HomePage hp=new HomePage(driver);
			hp.clk_Desktops();
			hp.clk_ShowAllDesktops();
			
			WishList wl=new WishList(driver);
			wl.clk_Laptops_Notebooks();
			wl.pdt_MacBookAir();
			wl.title_MacBook();
			wl.clk_AddToWishList();
			wl.msg_after_clk_onWLIcon();
			wl.clk_WishList_header();
			wl.title_MyWishList();
			wl.pdtName_MacBook();
			wl.clk_AddToCart_btn();
			wl.msg_After_clk_cartBTN();
			wl.clk_remove_btn();
			wl.msg_After_clk_removeBTN();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
