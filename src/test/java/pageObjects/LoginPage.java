package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(id="input-email")
	WebElement txt_email;
	
	@FindBy(id="input-password")
	WebElement txt_pwd;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement btn_login;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	//actions
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	
	public boolean isMyacPageExist()
	{
		try 
		{
			return (msgHeading.isDisplayed());
		} 
		catch (Exception e) 
		{
			return false;
		}	
	}
}
