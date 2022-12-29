package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInformation 
{
	WebDriver driver;
	public MyAccountInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a")
	WebElement MyAccount_drp;
	public void clk_MyAccount_drp() 
	{
		MyAccount_drp.click();
	}
	
	@FindBy(xpath="//a[@class='dropdown-item' and text()='My Account']")
	WebElement lnk_MyAccount_menu;
	
	@FindBy(xpath="//h1[text()='My Account Information']")
	WebElement title_MyAccountInformation;
	
	@FindBy(id="input-firstname")
	WebElement txt_FirstName;
	
	@FindBy(id="input-lastname")
	WebElement txt_LastName;
	
	@FindBy(id="input-email")
	WebElement txt_Email;
	
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/div/div[1]/a")
	WebElement btn_Back;
	
	@FindBy(id="error-email")
	WebElement error_msg;
	
	public void clk_MyAccount_menu()
	{
		lnk_MyAccount_menu.click();
	}
	
	public boolean title_MyAccountInformation()
	{
		try 
		{
			return (title_MyAccountInformation.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	public void set_FirstName()
	{
		txt_FirstName.clear();
	}
	public void set_LastName()
	{
		txt_LastName.clear();
	}
	public void set_Email()
	{
		txt_Email.clear();
	}
	public void clk_Continue()
	{
		btn_Continue.click();
	}
	public String error_msg()			//E-Mail Address does not appear to be valid!
	{
		try {
			return (error_msg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	public void btn_Back()
	{
		btn_Back.click();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement title_MyAccount;
	public String title_MyAccount()
	{
		try {
			return (title_MyAccount.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
