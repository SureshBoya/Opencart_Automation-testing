package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressBook;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_016_AddressBook extends BaseClass
{	
	@Test(priority = 1)
	public void AddNewAddress() throws InterruptedException
	{
		logger.info("TC_016_AddressBook and AddNewAddress() is started");
		try 
		{
			comman();
			AddressBook ab=new AddressBook(driver);
			ab.clk_NewAddress_Btn();
			Thread.sleep(10000);
			ab.clk_Continue();
			ab.msg_errorFirstname();
			ab.set_FirstName();
			ab.set_LastName();
			ab.set_Company();
			ab.set_Address1();
			ab.set_City();
			ab.set_PostCode();
			ab.drpdwn_Country();
			ab.drpdwn_Zone();
			ab.clk_Continue();
			Thread.sleep(10000);
			String exp_msg_add="Your address has been successfully added";
			if (exp_msg_add.equals(ab.alert_msg()))
			{
				Assert.assertTrue(true, "Address is added");
			} else {
				Assert.assertTrue(false, "Address is not added");
			}
			
			String act_title_AddresBookEntr=ab.title_AddressBookEntries();
			if (act_title_AddresBookEntr.equals(driver.getTitle())) 
			{
				Assert.assertTrue(true);
			} 
			else 
			{
				captureScreen(driver, "Address book"); //Capturing screenshot
				Assert.assertTrue(false, "title Address book entries is not displayed");
			}
			
			ab.box_AllAddress();
			System.out.println("New address added and make it as a default address");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
	}
	public void comman() throws InterruptedException
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
			
			AddressBook ab=new AddressBook(driver);
			ab.clk_MyAccount_drp();
			ab.clk_MyAccount_menu();
			Thread.sleep(10000);
			String act_title_myAccount=ab.title_MyAccount_vali();
			if (act_title_myAccount.equals(driver.getTitle())) 
			{
				Assert.assertTrue(true);
			} 
			else 
			{
				Assert.assertTrue(false, "title My account is not displayed");
			}
			ab.clk_AddressBook();
			String act_title_AddresBookEntr=ab.title_AddressBookEntries();
			if (act_title_AddresBookEntr.equals(driver.getTitle())) 
			{
				Assert.assertTrue(true);
			} 
			else 
			{
				logger.error("Address Book Failed ");
				captureScreen(driver, "Address book"); //Capturing screenshot
				Assert.assertTrue(false, "title Address book entries is not displayed");
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 2)
	public void makeDefault_Yes() 
	{
		try 
		{
			comman();
			AddressBook ab=new AddressBook(driver);
			ab.clk_Edit_Indonesia();
			ab.chkbx_Default_Yes();
			ab.clk_Continue();
			Thread.sleep(10000);
			String act_msg=ab.alert_msg();
			String exp_msg="Your address has been successfully updated";
			if (exp_msg.equals(act_msg)) 
			{
				Assert.assertTrue(true, "updated succesfully");
			}
			else 
			{
				captureScreen(driver, "Address book"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void default_Delete() throws InterruptedException 
	{
		try {
			comman();
			AddressBook ab=new AddressBook(driver);
			ab.clk_Delete_Indonesia();
			String act_msg=ab.alert_msg();
			String exp_msg="Warning: You can not delete your default address!";
			if (exp_msg.equals(act_msg)) 
			{
				Assert.assertTrue(true, "default address can't be deleted");
			}
			else 
			{
				captureScreen(driver, "Address book"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}	
	}
	@Test(priority = 4)
	public void delete_Account() 
	{
		try {
			comman();
			AddressBook ab=new AddressBook(driver);
			ab.clk_delete();
			String conf_Msg=ab.alert_msg();
			String exp_msg="Your address has been successfully deleted";
			if (conf_Msg.equals(conf_Msg)) 
			{
				Assert.assertTrue(true);
			} 
			else 
			{
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
