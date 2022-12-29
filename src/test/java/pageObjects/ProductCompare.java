package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCompare {

	WebDriver driver;
	public ProductCompare(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//a[text()='Desktops']")
	WebElement lnk_deshtops;
	
	@FindBy(xpath="//a[text()='Show All Desktops']")
	WebElement lnk_ShowAllDesktops;
	
	@FindBy(xpath="//h2[text()='Desktops']")
	WebElement title_desktops;
	
	@FindBy(xpath="//div[@class='mb-3']")
	WebElement lnk_productcompare_number;
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[2]/button[3]")
	WebElement icon_compareThisProduct;
	
	@FindBy(xpath="//ul[@class='breadcrumb']")
	WebElement breadcrumb;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_afterAddingproduct;
	
	@FindBy(xpath="//a[text()='product comparison']")
	WebElement productCompare_in_alertmsg;
	
	@FindBy(xpath="//h1[text()='Product Comparison']")
	WebElement title_ProductCompare;
	
	@FindBy(xpath="//*[@id='content']/div/div/a")
	WebElement btn_Continue;
	
	@FindBy(xpath="//title[text()='Your Store']")
	WebElement tile_HomePage;
	
	@FindBy(xpath="//*[@id='content']/p")
	WebElement msg_inProductCompare;
	
	@FindBy(id="button-confirm")
	WebElement btn_addToCart;
	
	@FindBy(xpath="//a[@class='btn btn-danger btn-block']")
	WebElement btn_remove;
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[2]/button[3]")
	WebElement pdtcmp_icon_Apple;
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div[2]/form/div/div[2]/div[2]/button[3]")
	WebElement pdtcmp_icon_cannon;
	
	//Actions
	public void desktops()
	{
		lnk_deshtops.click();
	}
	
	public void showAllDesktops()
	{
		lnk_ShowAllDesktops.click();
	}
	
	public void cannon()
	{
		pdtcmp_icon_cannon.click();
	}
	
	public void iconProductCompare()
	{
		icon_compareThisProduct.click();
	}
	
	public void msgAfterClickingProductCompare()
	{
		String status=msg_afterAddingproduct.getText();
		if (status.contains("Product Compare")) 
		{
			System.out.println(msg_afterAddingproduct.getText());
			Assert.assertEquals(status, true);
		}
		else 
		{
			Assert.assertEquals(status, false);
		}
		
	}
	
	public void clickProductCompareinMsg()
	{
		productCompare_in_alertmsg.click();
	}
	
	public void productCompareNo()
	{
		lnk_productcompare_number.click();
	}
	
	public void productApple()
	{
		pdtcmp_icon_Apple.click();
	}
	
	public void prdtCmpMsgWhen0prdt()
	{
		System.out.println(msg_inProductCompare.getText());
	}
	
	public void buttonContinue()
	{
		btn_Continue.click();
	}
	
	public String homePageTitle()
	{
		try 
		{
			return (tile_HomePage.getText());
		} 
		catch (Exception e)
		{
			return(e.getMessage());
		}	
	}
	
	public void addToCart()
	{
		btn_addToCart.click();
	}
	
	public void remove()
	{
		btn_remove.click();
	}
}
