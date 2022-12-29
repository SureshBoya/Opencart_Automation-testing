package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCart {
	
	WebDriver driver;
	public AddToCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"narbar-menu\"]/ul/li[1]/a")
	WebElement lnk_Desktops;
	
	@FindBy(xpath="//*[@id=\"narbar-menu\"]/ul/li[1]/div/a")
	WebElement lnk_ShowAllDesktops;
	
	@FindBy(xpath="//a[@class='list-group-item active' and contains(text(),'Phones & PDAs ')]")
	WebElement lnk_Phones_PADs;
	
	@FindBy(xpath="//h4//a[text()='HTC Touch HD']")
	WebElement lnk_pdtname_HTCtouchHd;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/form/div/button[2]")
	WebElement icon_CompareThisProduct;
	
	@FindBy(id="input-quantity")
	WebElement txt_Qtyfield;
	
	@FindBy(id="button-cart")
	WebElement btn_AddToCart;
	
	@FindBy(xpath="//button[@class='btn btn-light']//i[@class='fas fa-heart']")
	WebElement icon_addToWishList;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_afterAddingproduct;
	
	@FindBy(xpath="//*[@id=\"wishlist-total\"]/span")
	WebElement lnk_header_Wishlist;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[1]")
	WebElement icon_AddToCart_inWL;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a/span")
	WebElement lnk_header_ShoppingCart;
	
	@FindBy(xpath="//*[@id=\"shopping-cart\"]/div/table/tbody/tr/td[2]/a")
	WebElement lnk_HTCpdtName_inSC;
	
	@FindBy(xpath="//div[@id='content']//h1[text()='My Wishlist']")
	WebElement title_MyWishList;
	
	@FindBy(xpath="//*[@id=\"logo\"]/a/img")
	WebElement title_HomePage;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2")
	WebElement title_Phones_PADs;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/h1")
	WebElement title_HTC;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[1]")
	WebElement btn_AddToCartinWl;
	
	@FindBy(xpath="//a[text()='shopping cart']")
	WebElement lnk_ShoppingCart_inmsg;
	
	@FindBy(xpath="//*[@id=\"shopping-cart\"]/div/table/tbody/tr/td[2]/a")
	WebElement pdtName_inSC;
	
	@FindBy(xpath="//a[text()='product comparison']")
	WebElement pdtCmp_lnk_inMSG;

	public void pdt_HTC_SC() throws InterruptedException
	{
		lnk_Desktops.click();
		lnk_ShowAllDesktops.click();
		lnk_Phones_PADs.click();
		if (title_Phones_PADs.getText().equals("Phones & PDAs")) 
		{
			Assert.assertEquals(title_Phones_PADs, true,"Phones & Pads page is not displaying");
		}
		lnk_pdtname_HTCtouchHd.click();
		if (title_HTC.getText().equals(" HTC Touch HD"))
		{
			Assert.assertEquals(title_HTC, true,"HTC phone product is not getted");
		}
		icon_addToWishList.click();
		System.out.println(msg_afterAddingproduct.getText());
		lnk_header_Wishlist.click();
		
		if(title_MyWishList.getText().equals("My Wishlist"))
		{
			Assert.assertEquals(title_MyWishList, true);
		}
		else
		{
			Assert.assertEquals(title_MyWishList, false,"My wishlist tile is not displaying");
			title_HomePage.click();
		}
		btn_AddToCartinWl.click();
		Thread.sleep(1000);
		System.out.println(msg_afterAddingproduct.getText());
		lnk_ShoppingCart_inmsg.click();
		if (pdtName_inSC.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		icon_CompareThisProduct.click();
		System.out.println(msg_afterAddingproduct.getText());
		
		pdtCmp_lnk_inMSG.click();
		
		if (title_pdtCmp_page.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		btn_AddToCart_inPC.click();
	}
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_pdtCmp_page;
	
	@FindBy(xpath="button-confirm")
	WebElement btn_AddToCart_inPC;	
}
