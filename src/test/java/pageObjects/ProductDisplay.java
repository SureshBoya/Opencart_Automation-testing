package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductDisplay {
	
	WebDriver driver;
	public ProductDisplay(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//a[text()='Desktops']")
	WebElement lnk_deshtops;
	
	public void deskTops()
	{
		lnk_deshtops.click();
	}
	
	@FindBy(xpath="//a[@class='nav-link' and text()='Mac (1)']")
	WebElement lnk_mac;
	
	public void lnkMacPdt()
	{
		lnk_mac.click();
	}
	
	@FindBy(xpath="//div[@class='description']//a[text()='iMac']")
	WebElement pdt_imac;
	
	public void iMac_img_srhrst()
	{
		pdt_imac.click();
	}
	
	@FindBy(xpath="//img[@class='img-thumbnail mb-3' and @title='iMac']")
	WebElement pdt_imac_thumbnailIMG;
	
	public void iMacThumbnail()
	{
		pdt_imac.click();
	}
	
	@FindBy(xpath="//button[@class='mfp-arrow mfp-arrow-right mfp-prevent-close']")
	WebElement rightarrow_lightBox;
	
	public void rightArrow_iMac_img() throws AWTException, InterruptedException
	{
		Thread.sleep(10000);
		for(int i=0; i<=3; i++)
		{
			rightarrow_lightBox.click();
		}
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	@FindBy(xpath="//div[@class='col-sm']//h1[text()='iMac']")
	WebElement pdt_iMac_title;
	
	public void iMac_pdt_title()
	{
		if(pdt_iMac_title.getText().equals("iMac"))
		{
			Assert.assertEquals(pdt_iMac_title, true);
		}
		else
		{
			Assert.assertEquals(pdt_iMac_title, false, "product name is mot matching with the product name");
		}
	}
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[text()='Apple']")
	WebElement iMac_brandName;
	
	public void iMac_BrandName()
	{
		if (iMac_brandName.getText().equals("Apple")) 
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(xpath="//li[text()='Product Code: Product 14']")
	WebElement iMac_pdtCode;
	
	@FindBy(xpath="//li[text()='Availability: In Stock']")
	WebElement iMac_Availability;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/form/div/button[1]")
	WebElement icon_AddToWishList;
	
	@FindBy(xpath="//*[@id=\"alert\"]/div")
	WebElement mag_AfterClkOnAddToWishList;
	
	@FindBy(xpath="/div/a[2]")
	WebElement wishListlnk_in_msg;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_MyWishList;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//tr[1]//td[2]//a[text()='iMac']")
	WebElement lnk_iMacpdt_inWL;
	
	@FindBy(xpath="//*[@id=\"alert\"]/div/a[2]")
	WebElement lnk_comparePDT_inMSG;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_ProductCompare;
	public void iMac_pdt() throws InterruptedException
	{
		if (iMac_Availability.getText().contains("In Stock")) 
		{
			icon_AddToWishList.click();
			Thread.sleep(1000);
			wishListlnk_in_msg.click();
			if (title_MyWishList.getText().equals("My Wishlist")) 
			{
				Assert.assertEquals(title_MyWishList, true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			lnk_iMacpdt_inWL.click();
			Thread.sleep(10000);
			Assert.assertEquals(pdt_iMac_title.getText(), true);
			
			icon_CompareThisProduct.click();
			lnk_comparePDT_inMSG.click();
			Assert.assertEquals(title_ProductCompare.getText(), true,"After click on product compare link in alert message, then it's not redirecting to the Compare product page");
			btn_AddToCart.click();
			Assert.assertEquals(msg_afterclkOnAddToCart_btn.getText(), true);
			lnk_ShoppingCart_inMSG.click();
			Assert.assertEquals(title_ShoppingCart.getText(), true, "Shopping cart gets failed");
			Assert.assertEquals(pdtName_in_SCtable.getText(), true,"iMac product is not displaying in Shopping cart page");
			btn_Cartitems.click();
			Assert.assertEquals(iMac_lnk_inCartToggle.getText(), true,"iMac product is not displaying in cart toggle box");
		}
	}
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right show']//table//tr[1]//td[2]//a")
	WebElement iMac_lnk_inCartToggle;
	
	@FindBy(xpath="//*[@id=\"header-cart\"]/div/button")
	WebElement btn_Cartitems;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/form/div/button[2]")
	WebElement icon_CompareThisProduct;
	
	@FindBy(id="input-quantity")
	WebElement txt_Qtyfield_imac;
	
	@FindBy(id="button-cart")
	WebElement btn_AddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_afterclkOnAddToCart_btn;
	
	@FindBy(xpath="//a[text()='shopping cart']")
	WebElement lnk_ShoppingCart_inMSG;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement title_ShoppingCart;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr[1]//td[2]//a")
	WebElement pdtName_in_SCtable;

	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr[1]//td[4]//div[1]//input[1]")
	WebElement txt_QtyField_SCtable;
	
	@FindBy(xpath="//table[@class='table table-bordered']//tbody//tr[1]//td[4]//div[1]//button[1]//i[1]")
	WebElement btn_Update_SCtable;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_aftClkUpdate_inSCtable;
	
	@FindBy(id="input-option-value-5")
	WebElement sml_chkbox_Apple;
	
	@FindBy(id="input-option-value-8")
	WebElement chkbox_Apple;
	
	@FindBy(id="input-option-208")
	WebElement txtText_Apple;
	
	@FindBy(id="input-option-217")
	WebElement selectdrp;
	
	
	public void select() 
	{
		Select sel=new Select(selectdrp);
		sel.selectByVisibleText("Red (+$6.80)");
	}
	
	@FindBy(id="input-option-209")
	WebElement txt_textArea;
	
	@FindBy(id="button-upload-222")
	WebElement uploadField;
	
	@FindBy(id="input-option-219")
	WebElement date;
	
	@FindBy(id="input-option-221")
	WebElement time;
	
	@FindBy(id="input-option-220")
	WebElement date_time;
	
	@FindBy(id="input-quantity")
	WebElement txt_Qtyfield_Apple;
	
	@FindBy(id="input-quantity")
	WebElement msgUND_AddToCart_apple;
	
	public void date(String datee,String timee, String date_tim)
	{
		date.sendKeys(datee);
		time.sendKeys(timee);
		date_time.sendKeys(date_tim);
	}
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[1]/h4/a")
	WebElement name_lnk_ApplePDT;
	
	@FindBy(xpath="//div[@class='col-sm']//h1[text()='Apple Cinema 30\"']")
	WebElement pdt_Apple_title;
	
	@FindBy(xpath="//a[text()='Apple Cinema 30\"']")
	WebElement pdtlnk_apple_inWL;
	
	public void applePDT() throws InterruptedException, AWTException
	{
		name_lnk_ApplePDT.click();
		
		Thread.sleep(10000);
		for(int i=0; i<=3; i++)
		{
			rightarrow_lightBox.click();
		}
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		
		if(pdt_Apple_title.getText().contains("Apple Cinema 30"))
		{
			Assert.assertEquals(pdt_Apple_title, true);
		}
		else
		{
			Assert.assertEquals(pdt_Apple_title, false, "product name is mot matching with the product name");
		}
		
		if (iMac_Availability.getText().contains("In Stock")) 
		{
			icon_AddToWishList.click();
			Thread.sleep(1000);
			wishListlnk_in_msg.click();
			if (title_MyWishList.getText().equals("My Wishlist")) 
			{
				Assert.assertEquals(title_MyWishList, true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			pdtlnk_apple_inWL.click();
			Thread.sleep(10000);
			Assert.assertEquals(pdt_Apple_title.getText(), true);
			
			icon_CompareThisProduct.click();
			lnk_comparePDT_inMSG.click();
		//	Assert.assertEquals(title_ProductCompare.getText(), true,"After click on product compare link in alert message, then it's not redirecting to the Compare product page");
		//	btn_AddToCart.click();
		//	Assert.assertEquals(msg_afterclkOnAddToCart_btn.getText(), true);
		//	lnk_ShoppingCart_inMSG.click();
		//	Assert.assertEquals(title_ShoppingCart.getText(), true, "Shopping cart gets failed");
		//	Assert.assertEquals(pdtName_in_SCtable.getText(), true,"iMac product is not displaying in Shopping cart page");
		//	btn_Cartitems.click();
		//	Assert.assertEquals(iMac_lnk_inCartToggle.getText(), true,"iMac product is not displaying in cart toggle box");
		}
	}
	public void appleFields(String text,String textArea,String qty)
	{
		txtText_Apple.sendKeys(text);
		txt_textArea.sendKeys(textArea);
		txt_Qtyfield_Apple.sendKeys(qty);
	}
	
	@FindBy(partialLinkText = "Wish List ")
	WebElement lnk_WishList;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr[2]/td[2]/a")
	WebElement lnk_apple_inWL;
	
	@FindBy(xpath="//*[@id=\"header-cart\"]/div/button")
	WebElement lnk_Cart;
	
	@FindBy(xpath="//*[@id=\"header-cart\"]/div/ul/li/div/p/a[1]/strong")
	WebElement btn_ViewCart_intoggleCart;
	
	
}
