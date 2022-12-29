package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddressBook 
{
	/*
Warning: You can not delete your default address!
Your address has been successfully deleted
Your address has been successfully added
Your address has been successfully updated
*/
	WebDriver driver;
	public AddressBook(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a")
	WebElement MyAccount_drp;
	
	@FindBy(xpath="//a[@class='dropdown-item' and text()='My Account']")
	WebElement lnk_MyAccount_menu;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement title_MyAccountPage;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[3]/a")
	WebElement lnk_AddressBook;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_AddressBookEntries;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
	WebElement btn_NewAddress;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/a")
	WebElement btn_Back;
	
	//New Address
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_AddAddress;
	public String title_AddAddress_vali() 
	{
		try 
		{
			return (title_AddAddress.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	@FindBy(xpath="//*[@id=\"form-address\"]/div/div[2]/button")
	WebElement btn_Continue;
	public void clk_Continue() 
	{
		btn_Continue.click();
	}
	
	@FindBy(xpath="//*[@id=\"form-address\"]/div/div[1]/a")
	WebElement btn_Back_InAddAddress;
	public void btn_Back_InAddAddress() 
	{
		btn_Back_InAddAddress.click();
	}
	
	@FindBy(id="error-firstname")
	WebElement msg_errorFirstname;
	public boolean msg_errorFirstname() 
	{
		return (msg_errorFirstname.isDisplayed());
	}
	
	@FindBy(id="input-firstname")
	WebElement txt_FirstName;
	public void set_FirstName() 
	{
		txt_FirstName.sendKeys("SureshBoya");
	}
	
	@FindBy(id="input-lastname")
	WebElement txt_LastName;
	public void set_LastName() 
	{
		txt_LastName.sendKeys("Boya");
	}
	
	@FindBy(id="input-company")
	WebElement txt_Company;
	public void set_Company()
	{
		txt_Company.sendKeys("Startup");
	}
	
	@FindBy(id="input-address-1")
	WebElement txt_Address1;
	public void set_Address1() 
	{
		txt_Address1.sendKeys("Madhapur");
	}
	
	@FindBy(id="input-city")
	WebElement txt_City;
	public void set_City() 
	{
		txt_City.sendKeys("Hyderabad");
	}
	
	@FindBy(id="input-postcode")
	WebElement txt_PostCode;
	public void set_PostCode() 
	{
		txt_PostCode.sendKeys("500006");
	} 
	
	@FindBy(id="input-country")
	WebElement drpdwn_Country;
	public void drpdwn_Country() 
	{
		Select cont=new Select(drpdwn_Country);
		cont.selectByVisibleText("India");
	}
	
	@FindBy(id="input-zone")
	WebElement drpdwn_Zone;
	public void drpdwn_Zone() 
	{
		Select zone=new Select(drpdwn_Zone);
		zone.selectByVisibleText("Telangana");
	}
	
	@FindBy(id="input-default-yes")
	WebElement chkbx_Default_Yes;
	public void chkbx_Default_Yes()
	{
		chkbx_Default_Yes.click();
	}
	
	public void clk_MyAccount_drp() 
	{
		MyAccount_drp.click();
	}
	public void clk_MyAccount_menu()
	{
		lnk_MyAccount_menu.click();
	}
	public String title_MyAccount_vali()
	{
		try 
		{
			return (title_MyAccountPage.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	public void clk_AddressBook()
	{
		lnk_AddressBook.click();
	}
	public String title_AddressBookEntries()
	{
		try 
		{
			return (title_AddressBookEntries.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	public void clk_NewAddress_Btn()
	{
		btn_NewAddress.click();
	}
	public void btn_Back() 
	{
		btn_Back.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_msg;
	public String alert_msg() 
	{
		try
		{
			return (alert_msg.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	@FindBy(xpath="//*[@id=\"content\"]")
	WebElement box_AllAddress;
	public void box_AllAddress() 
	{
		String verification=box_AllAddress.getText();
		if (verification.contains("India")) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	//makeDefault yes
	@FindBy(xpath="//tr[1]//td[1][@class='text-start']/..//a[.='Edit']")
	WebElement btn_Edit_Indonesia;
	public void clk_Edit_Indonesia() 
	{
		btn_Edit_Indonesia.click();
	}
	
	@FindBy(xpath="//tr[1]//td[1][@class='text-start']/..//a[.='Delete']")
	WebElement btn_Delete_Indonesia;
	public void clk_Delete_Indonesia() 
	{
		btn_Delete_Indonesia.click();
	}
	
	//Delete a account
	@FindBy(xpath="//tr[3]//td[1][@class='text-start']/..//a[text()='Delete']")
	WebElement lnk_Delete;
	public void clk_delete()
	{
		lnk_Delete.click();
	}
}
