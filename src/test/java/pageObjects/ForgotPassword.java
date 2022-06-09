package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {

	WebDriver driver;
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//div[@class='card-body']//a[text()='Forgotten Password']")
	WebElement lnk_ForgotPassword;
	
	@FindBy(id="input-email")
	WebElement txt_email_in_forgotpwd;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement btn_continue;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement aletmsg_forForgotpwd;
	
	//Action methods
	public void clickonMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void clickOnForgotPwd()
	{
		txt_email_in_forgotpwd.click();
	}
	
	public void clickOnForgotPwdfield(String email)
	{
		txt_email_in_forgotpwd.sendKeys("email");
	}
	
	public void clickOnContinueButton()
	{
		btn_continue.click();
	}
	
	public String alert_msg_for_ForgotPwd()
	{
		try 
		{
			return (aletmsg_forForgotpwd.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
}
