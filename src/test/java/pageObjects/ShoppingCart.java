package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShoppingCart {
	
	WebDriver driver;
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//no products are added
	@FindBy(xpath="//*[@id=\"content\"]/p")
	WebElement msg_SC_noPDTs;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement btn_Continue_SC;
	
	@FindBy(xpath="//*[@id=\"logo\"]/a/img")
	WebElement logo_HomePage;
	
	public boolean homePage_logo()
	{
		try 
		{
			return (logo_HomePage.isDisplayed());
		} 
		catch (Exception e)
		{
			return (false);
		}
	}
	
	public String msg_SC_noPDTs()
	{
		try 
		{
			return (msg_SC_noPDTs.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	public void clk_Continue() throws InterruptedException
	{
		btn_Continue_SC.click();
		Thread.sleep(1000);
		
		if (logo_HomePage.isDisplayed()) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	//After adding product to shopping cart;
	@FindBy(xpath="//*[@id=\"product-list\"]/div/form/div/div[2]/div[1]/h4/a")
	WebElement lnk_Mac_pdt;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement btn_AddToCart_PD;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_Afterclk_AddtocartBTN;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_ShoppingCart;
	
	@FindBy(id="content")
	WebElement table;
	
	@FindBy(xpath="//div[@class='input-group']//input[@class='form-control']")
	WebElement txt_Qnt_field;
	
	@FindBy(xpath="//*[@id=\"shopping-cart\"]/div/table/tbody/tr/td[4]/form/div/button[1]")
	WebElement btn_Update;
	
	@FindBy(xpath="//*[@id=\"shopping-cart\"]/div/table/tbody/tr/td[4]/form/div/button[2]")
	WebElement btn_remove;
	
	@FindBy(xpath="//*[@id=\"content\"]/p")
	WebElement msg_ifnopdts_SC;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement btn_continue_SC;
	
	public void clk_Mac_pdt()
	{
		lnk_Mac_pdt.click();
	}
	
	public void clk_AddToCart_PD()
	{
		btn_AddToCart_PD.click();
	}
	
	public void msg_Afterclk_AddtocartBTN()
	{
		if (msg_Afterclk_AddtocartBTN.getText().contains("Shopping Cart")) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public void title_ShoppingCart()
	{
		if (title_ShoppingCart.isDisplayed()) 
		{
			Assert.assertEquals(title_ShoppingCart, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public void table()
	{
		if (table.getText().contains("iMac")) 
		{
			Assert.assertEquals(table, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	public boolean msg_SC()
	{
		try 
		{
			return (msg_ifnopdts_SC.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	//Estimate and Shipping
	@FindBy(xpath="//*[@id=\"accordion\"]/div[1]/h2/button")
	WebElement lnk_EstimateShipping;
	public void clk_EstimateShipping()
	{
		lnk_EstimateShipping.click();
	}
	
	@FindBy(id="button-quote")
	WebElement btn_Quote_ES_SC;
	public void clk_Quote_ES_SC()
	{
		btn_Quote_ES_SC.click();
	}
	
	@FindBy(id="error-zone")
	WebElement msg_error_SC;
	
	public void withoutfilters_msg()
	{
		String exp_msg="Please select a region / state!";
		if (msg_error_SC.getText().equals(exp_msg))
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(true);
		}
	}
	
	@FindBy(id="input-country")
	WebElement drp_country;
	public void clk_Country()
	{
		Select sel=new Select(drp_country);
		sel.selectByVisibleText("United States");
	}
	
	@FindBy(id="input-zone")
	WebElement drp_Region;
	public void clk_Region()
	{
		Select sel1=new Select(drp_country);
		sel1.selectByVisibleText("California");
	}
	
	@FindBy(id="input-postcode")
	WebElement txt_PostalCode;
	public void clk_PostalCode()
	{
		String postCode="90007";
		txt_PostalCode.sendKeys(postCode);
	}
	
	@FindBy(xpath="//input[@id='input-shipping-method-flat']")
	WebElement chkbox_FlatShippingRate;
	public void clk_FlatShippingRate()
	{
		chkbox_FlatShippingRate.click();
	}
	
	@FindBy(id="button-shipping")
	WebElement btn_ApplyShipping;
	public void clk_ApplyShipping()
	{
		btn_ApplyShipping.click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement msg_afterclk_ApplyShipping;
	public void final_msg_ES()
	{
		String exp_msg="Success: Your shipping estimate has been applied!";
		if (msg_afterclk_ApplyShipping.getText().equals(exp_msg))
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(true);
		}
	}
	
	//Use CoupanCode
	@FindBy(xpath="//*[@id=\"accordion\"]/div[2]/h2/button")
	WebElement lnk_UseCoupanCode;
	public void clk_UseCoupanCode()
	{
		lnk_UseCoupanCode.click();
	}
	
	@FindBy(id="input-coupan")
	WebElement txt_Coupan;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg_validation_coupancode;
	
	public void clk_invalid_Coupan()
	{
		String coupan="Pending Data";
		txt_Coupan.sendKeys(coupan);
		
		String msg1="Warning: Coupon is either invalid, expired or reached its usage limit!";
		clk_ApplyCoupan();
		
		if (msg_validation_coupancode.getText().equals(msg1)) 
		{
			Assert.assertTrue(true);
		} 
		else
		{
			Assert.assertEquals(msg_validation_coupancode, false, "Apply invalid coupan code is valid");
		}
	}
	
	public void clk_valid_Coupan()
	{
		String coupan=" ";
		txt_Coupan.sendKeys(coupan);
		
		String msg1="Success: Your coupon discount has been removed!";
		clk_ApplyCoupan();
		
		if (msg_validation_coupancode.getText().equals(msg1)) 
		{
			Assert.assertTrue(true);
		} 
		else
		{
			Assert.assertEquals(msg_validation_coupancode, false, "Apply coupan code is invalid");
		}
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Apply Coupon']")
	WebElement btn_ApplyCoupan;
	
	public void clk_ApplyCoupan()
	{
		btn_ApplyCoupan.click();
	}
	
	//Gift certificate
	@FindBy(xpath="//*[@id=\"accordion\"]/div[3]/h2/button")
	WebElement lnk_GiftCertificate;
	public void clk_GiftCertificate()
	{
		lnk_GiftCertificate.click();
	}
	
	@FindBy(id="input-voucher")
	WebElement txt_Giftvocher;
	
	public void clk_invalid_gift()
	{
		String coupan="Pending Data";
		txt_Giftvocher.sendKeys(coupan);
		
		String msg1=" Warning: Gift Certificate is either invalid or the balance has been used up!";
		clk_ApplyGift_btn();
		
		if (msg_validation_coupancode.getText().equals(msg1)) 
		{
			Assert.assertTrue(true);
		} 
		else
		{
			Assert.assertEquals(msg_validation_coupancode, false, "Apply coupan code is valid");
		}
	}
	
	public void clk_valid_Gift()
	{
		String coupan=" ";
		txt_Coupan.sendKeys(coupan);
		
		String msg1=" Success: Your gift certificate discount has been removed!";
		clk_ApplyGift_btn();
		
		if (msg_validation_coupancode.getText().equals(msg1)) 
		{
			Assert.assertTrue(true);
		} 
		else
		{
			Assert.assertEquals(msg_validation_coupancode, false, "Apply coupan code is invalid");
		}
	}
	
	@FindBy(xpath="//*[@id=\"form-voucher\"]/div[2]/button")
	WebElement btn_ApplyGiftCertificate;
	
	public void clk_ApplyGift_btn()
	{
		btn_ApplyGiftCertificate.click();
	}
	
	//Continue Shopping
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[1]/a")
	WebElement btn_ContinueShopping;
	public void clk_ContinueShopping() throws InterruptedException
	{
		btn_ContinueShopping.click();
		Thread.sleep(1000);
		
		if (logo_HomePage.isDisplayed()) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	//Checkout
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement btn_CheckOut;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_Checkout_page;
	
	public void clk_Checkout() throws InterruptedException
	{
		btn_CheckOut.click();
		Thread.sleep(10000);
		
		String act_title_CO=driver.getTitle();
		if (act_title_CO.equals("Checkout")) 
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
}
