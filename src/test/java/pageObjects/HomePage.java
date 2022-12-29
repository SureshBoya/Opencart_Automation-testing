package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"logo\"]/a/img")
	WebElement logo;
	
	public void logo_validation()
	{
		if (logo.isDisplayed()) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div")
	WebElement lnkMyaccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	@FindBy(xpath="//*[@id=\"narbar-menu\"]/ul/li[1]/a")
	WebElement lnk_btn_Desktops;
	
	@FindBy(xpath="//*[@id=\"narbar-menu\"]/ul/li[1]/div/a")
	WebElement lnk_btn_ShowAllDesktops;
	
	@FindBy(xpath="//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement lnk_btn_mac;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a")
	WebElement lnk_ShoppingCart_Header;
	
	@FindBy(xpath="//*[@id=\"header-cart\"]")
	WebElement lnk_cart;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[5]/a")
	WebElement lnk_Header_Checkout;
	
	public void clk_Header_Checkout()
	{
		lnk_Header_Checkout.click();
	}
	
	public void clk_Cart()
	{
		lnk_cart.click();
	}
	
	public void clk_ShoppingCart_header()
	{
		lnk_ShoppingCart_Header.click();
	}
	
	public void clk_Mac()
	{
		lnk_btn_mac.click();;
	}
	
	public void clk_Desktops()
	{
		lnk_btn_Desktops.click();
	}
	
	public void clk_ShowAllDesktops()
	{
		lnk_btn_ShowAllDesktops.click();
	}
		
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
