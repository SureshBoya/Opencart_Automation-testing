package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locations
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_SC_clk_Chechout;
	
	public void title_SC_clk_Chechout()
	{
		String act_value=driver.getTitle();
		String exp_value=title_SC_clk_Chechout.getText();
		if (exp_value.equals(act_value)) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(id="wishlist-total")
	WebElement lnk_Header_WishList;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[1]")
	WebElement icon_AddToCart;
	
	public void wishList_Header() throws InterruptedException
	{
		lnk_Header_WishList.click();
		Thread.sleep(10000);
		icon_AddToCart.click();
		Thread.sleep(10000);
	}
	
	
	//With product
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement btn_CheckOut;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_Checkout;
	
	public void title_Checkout_Vali()
	{
		String act_value=driver.getTitle();
		String exp_value=title_Checkout.getText();
		if (exp_value.equals(act_value)) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(id="input-payment-existing")
	WebElement chkbox_payment_existing_Add;
	
	public void clk_Chkbox_existing_Payment()
	{
		chkbox_payment_existing_Add.click();
	}
	
	@FindBy(id="input-payment-address")
	WebElement drpdown_txt_Add_Payment;
	
	public void select_add()
	{
		Select sel=new Select(drpdown_txt_Add_Payment);
		sel.selectByVisibleText("Suresh Boya, Hyd, Hyd, Bali, Indonesia");
	}
	
	@FindBy(id="input-shipping-existing")
	WebElement chkbox_Shipping_existing_Add;
	
	public void clk_Chkbox_existing_Shipping()
	{
		chkbox_Shipping_existing_Add.click();
	}
	
	@FindBy(id="input-shipping-method")
	WebElement drpdown_ShippingMethod;
	
	public void select_shippingmethod()
	{
		Select sel=new Select(drpdown_ShippingMethod);
		sel.selectByVisibleText("Flat Shipping Rate - $8.00");
	}
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement msg;
	
	public void shipping_msg_validation()
	{
		String exp_msg=" Success: You have changed shipping method!";
		String act_msg=msg.getText();
		if (act_msg.equals(exp_msg)) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(id="input-payment-method")
	WebElement drpdown_Paymentmethod;
	
	public void select_payment()
	{
		Select sel=new Select(drpdown_Paymentmethod);
		sel.selectByVisibleText("Cash On Delivery");
	}
	
	public void payment_msg_validation()
	{
		String exp_msg="  Success: You have changed payment method!";
		String act_msg=msg.getText();
		if (act_msg.equals(exp_msg)) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(id="input-comment")
	WebElement txt_comment;
	
	public void clk_Comment()
	{
		txt_comment.sendKeys("for testing purpose");
	}
	
	@FindBy(id="button-confirm")
	WebElement btn_ConfirmOrder;
	
	public void clk_ConfirmOrder()
	{
		btn_ConfirmOrder.click();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_OrderPlaced;
	
	public void oderPlaced_validation()
	{
		String exp_msg="Your order has been placed!";
		String act_msg=msg.getText();
		if (act_msg.equals(exp_msg)) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]/a[2]")
	WebElement lnk_History_inOrderPlaced;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_OrderHistory;
	
	public void clk_History_inOrderPlaced()
	{
		lnk_History_inOrderPlaced.click();
		
		if (title_OrderHistory.getText().equals(driver.getTitle())) 
		{
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement btn_Continue_OrderPlace;
	
	public void clk_Continue_OrderPlaced()
	{
		btn_Continue_OrderPlace.click();
		
		HomePage hp=new HomePage(driver);
		hp.logo_validation();
	}
	
	//new address of Billing details
	@FindBy(id="input-payment-new")
	WebElement chkbox_newAdd_Payment;
	
	public void clk_newAdd_Payment()
	{
		chkbox_newAdd_Payment.click();
	}
	
	@FindBy(id="button-payment-address")
	WebElement btn_Continue_payment;
	
	public void clk_Continue_payment()
	{
		btn_Continue_payment.click();
	}
	
	@FindBy(id="error-payment-firstname")
	WebElement error_firstName;
	
	public boolean error_valid()
	{
		return (error_firstName.isDisplayed());
	}
	
	@FindBy(id="input-payment-firstname")
	WebElement txt_FirstName_Payment;
	
	public void clk_FirstName_Payment()
	{
		txt_FirstName_Payment.sendKeys("Suresh");
	}
	
	@FindBy(id="input-payment-lastname")
	WebElement txt_LastName_Payment;
	public void clk_LastName_payment()
	{
		txt_LastName_Payment.sendKeys("B");
	}
	
	@FindBy(id="input-payment-company")
	WebElement txt_Company_Payment;
	public void clk_Company_payment()
	{
		txt_Company_Payment.sendKeys("IST hyd");
	}
	
	@FindBy(id="input-payment-address-1")
	WebElement txt_Addr1_Payment;
	public void clk_Addr1_payment()
	{
		txt_Addr1_Payment.sendKeys("Rudravaram, Indonesia");
	}
	@FindBy(id="input-payment-address-2")
	WebElement txt_Addr2_Payment;
	public void clk_Addr2_payment()
	{
		txt_Addr2_Payment.sendKeys("India");
	}
	
	@FindBy(id="input-payment-city")
	WebElement txt_City_Payment;
	public void clk_City_payment()
	{
		txt_City_Payment.sendKeys("Kurnool");
	}
	
	@FindBy(id="input-payment-postcode")
	WebElement txt_PostCode_Payment;
	public void clk_Postcode_payment() 
	{
		txt_PostCode_Payment.sendKeys("500006");
	}
	
	@FindBy(id="input-payment-country")
	WebElement drpdwn_Country_Payment;
	public void clk_Country_Payment()
	{
		Select sel=new Select(drpdwn_Country_Payment);
		sel.selectByVisibleText("India");
	}
	
	@FindBy(id="input-payment-zone")
	WebElement drpdwn_Zone_payment;
	public void clk_Zone_Payment()
	{
		Select sel=new Select(drpdwn_Zone_payment);
		sel.selectByVisibleText("Goa");
	}
	
	//shipping new address and bill existing address
	@FindBy(id="input-shipping-new")
	WebElement chkbox_newaddr_Shipping;
	
	public void clk_newAddr_Shipping()
	{
		chkbox_newaddr_Shipping.click();
	}
	
	@FindBy(id="input-shipping-firstname")
	WebElement txt_firstname_Shipping;
	public void clk_Firstname_Shipping()
	{
		txt_firstname_Shipping.sendKeys("Banana");
	}
	
	@FindBy(id="input-shipping-lastname")
	WebElement txt_Lasttname_Shipping;
	public void clk_Lastname_Shipping() 
	{
		txt_Lasttname_Shipping.sendKeys("fruit");
	}
	
	@FindBy(id="input-shipping-company")
	WebElement txt_Company_Shipping;
	public void clk_Company_shipping() 
	{
		txt_Company_Shipping.sendKeys("$$$$");
	}
	
	@FindBy(id="input-shipping-address-1")
	WebElement txt_Addr1_Shipping;
	public void clk_Addr1_Shipping()
	{
		txt_Addr1_Shipping.sendKeys("@@@@");
	}
	
	@FindBy(id="input-shipping-address-2")
	WebElement txt_Addr2_Shipping;
	public void clk_Addr2_Shipping()
	{
		txt_Addr2_Shipping.sendKeys("!!!");
	}
	
	@FindBy(id="input-shipping-city")
	WebElement txt_city_Shipping;
	public void clk_City_Shipping()
	{
		txt_city_Shipping.sendKeys("medan");
	}
	
	@FindBy(id="input-shipping-postcode")
	WebElement txt_postcaode_Shipping;
	public void clk_Postcode_Shipping() 
	{
		txt_postcaode_Shipping.sendKeys("222222");
	}
	
	@FindBy(id="input-shipping-country")
	WebElement drpdwn_Country;
	public void country_Shipping() 
	{
		Select se=new Select(drpdwn_Country);
		se.selectByVisibleText("Thailand");
	}
	
	@FindBy(id="input-shipping-zone")
	WebElement drpdwn_Zone;
	public void zone_Shipping() 
	{
		Select se=new Select(drpdwn_Zone);
		se.selectByVisibleText("Kara");
	}
	
	@FindBy(id="button-shipping-address")
	WebElement brn_Continue_Shipping;
	public void clk_Continue_Shipping() 
	{
		brn_Continue_Shipping.click();
	}
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[1]")
	WebElement icon_AddToCartBTN;
	public void clk_AddToCart()
	{
		icon_AddToCartBTN.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
