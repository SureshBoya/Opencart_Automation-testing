package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionality {
	WebDriver driver;
	public SearchFunctionality(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//div[@id='search']//input")
	WebElement txt_Search;
	
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	WebElement btn_Search;
}
