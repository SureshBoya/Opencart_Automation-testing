package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountHomePage 
{
	WebDriver driver;
	public MyAccountHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement menu_MyAccount;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a")
	WebElement MyAccount_drp;
	public void clk_MyAccount_drp() 
	{
		MyAccount_drp.click();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement title_MyAccount;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[1]/a")
	WebElement lnk_EditMyAccountPage;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[2]/a")
	WebElement lnk_ChanePwd;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[3]/a")
	WebElement lnk_ModifyUrAddressbook;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[4]/a")
	WebElement lnk_PaymentMethods;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[5]/a")
	WebElement lnk_ModifyUrWishlist;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[2]")
	WebElement title_MyOrders;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[1]/a")
	WebElement lnk_ViewUrOrderHistory;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[2]/a")
	WebElement lnk_Subscription;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[3]/a")
	WebElement lnk_Downloads;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[4]/a")
	WebElement lnk_UrRewordPoints;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[5]/a")
	WebElement lnk_ViewUrReturnRequirest;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[6]/a")
	WebElement lnk_UrTrasactions;
	
	public void clk_MyAccount()
	{
		menu_MyAccount.click();
	}
	
	public String title_MyAccount()
	{
		try 
		{
			return (title_MyAccount.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	public void clk_EditMyAccountPage()
	{
		lnk_EditMyAccountPage.click();
	}
	
	public void clk_ChangePwd()
	{
		lnk_ChanePwd.click();
	}
	
	public void clk_ModifyUrAddressBook()
	{
		lnk_ModifyUrAddressbook.click();
	}
	
	public void clk_PaymentMethods()
	{
		lnk_PaymentMethods.click();
	}
	
	public void clk_ModifyUrWishList()
	{
		lnk_ModifyUrWishlist.click();
	}
	
	public boolean title_MyOrders()
	{
		try 
		{
			return (title_MyOrders.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	
	public void clk_ViewUrOrderHistory()
	{
		lnk_ViewUrOrderHistory.click();
	}
	
	public void clk_Subscription()
	{
		lnk_Subscription.click();
	}
	
	public void clk_Downloads()
	{
		lnk_Downloads.click();
	}
	
	public void clk_UrRewordPoints()
	{
		lnk_UrRewordPoints.click();
	}
	
	public void clk_ViewUrReturn()
	{
		lnk_ViewUrReturnRequirest.click();
	}
	
	public void clk_UrTrasactions()
	{
		lnk_UrTrasactions.click();
	}
}
