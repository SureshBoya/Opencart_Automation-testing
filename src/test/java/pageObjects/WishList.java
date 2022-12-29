package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishList {

	WebDriver driver;
	public WishList(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//My Account page
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement lnk_btn_MyAccount;
	
	@FindBy(xpath="//div[@id='content']//h2[1]")
	WebElement title_MyAccount;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//li[5]//a[text()='Modify your wish list']")
	WebElement lnk_ModifyUrWishList;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_MyWishList;
	
	@FindBy(xpath="//div[@id='wishlist']")
	WebElement msg_if_NoPDTs;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btn_Continue;
	
	public void clk_MyAccount_lnk()
	{
		lnk_btn_MyAccount.click();
	}
	
	public void title_Myaccount()
	{
		if (title_MyAccount.getText().equals("My Account")) 
		{
			Assert.assertEquals(title_MyAccount, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public void clk_ModifyUrWishList()
	{
		lnk_ModifyUrWishList.click();
	}
	
	public void title_MyWishList()
	{
		if (title_MyWishList.getText().equals("My Wishlist")) 
		{
			Assert.assertEquals(title_MyWishList, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public String msg_inWL()
	{
		try 
		{
			return (msg_if_NoPDTs.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	
	public void clk_continue_btn()
	{
		btn_Continue.click();
	}
	
	//Pdt display page -> Wishlist -> Add to cart -> remove pdt
	@FindBy(xpath="//*[@id=\"column-left\"]/div[1]/a[2]")
	WebElement lnk_Laptops_Notebooks;
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div[3]/form/div/div[2]/div[1]/h4/a")
	WebElement pdt_MacBookAir;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/h1")
	WebElement pdt_title_MacBookAir;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[2]/form/div/button[1]/i")
	WebElement icon_AddToWishList;
	
	@FindBy(xpath="//*[@id=\"alert\"]")
	WebElement msg_after_clk_onIcon;
	
	@FindBy(xpath="//*[@id=\"wishlist-total\"]/span")
	WebElement lnk_WishList_header;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[2]/a")
	WebElement lnk_pdtName_MacBook;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[1]/i")
	WebElement btn_AddToCart;
	
	@FindBy(xpath="//*[@id=\"wishlist\"]/div/table/tbody/tr/td[6]/form/button[2]")
	WebElement btn_remove;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a/span")
	WebElement lnk_ShoppingCart_Header;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement title_ShoppingCart;
	
	@FindBy(id="content")
	WebElement table;
	
	@FindBy(xpath="//*[@id=\"alert\"]/div")
	WebElement msg_After_clk_cartBTN;
	
	@FindBy(xpath="//*[@id=\"alert\"]/div")
	WebElement msg_After_clk_removeBTN;
	
	public void clk_Laptops_Notebooks()
	{
		lnk_Laptops_Notebooks.click();
	}
	
	public void pdt_MacBookAir()
	{
		pdt_MacBookAir.click();
	}
	
	public void title_MacBook()
	{
		String expected_name="MacBook Air";
		if (pdt_title_MacBookAir.getText().equals(expected_name)) 
		{
			Assert.assertEquals(pdt_title_MacBookAir, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public void clk_AddToWishList()
	{
		icon_AddToWishList.click();
	}
	
	public void msg_after_clk_onWLIcon()
	{
		String expected_msg="Wish List";
		if (msg_after_clk_onIcon.getText().contains(expected_msg)) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	public void clk_WishList_header()
	{
		lnk_WishList_header.click();
	}
	
	public String pdtName_MacBook()
	{
		try 
		{
			return (lnk_pdtName_MacBook.getText());
		}
		catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
	 
	public void clk_AddToCart_btn()
	{
		btn_AddToCart.click();
	}
	 
	public void msg_After_clk_cartBTN()
	{
		String expected_msg="Success: You have added Product Name to your shopping cart!";
		if (msg_After_clk_cartBTN.getText().contains(expected_msg)) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
	/* public void clk_ShoppingCart_Header()
	{
		lnk_ShoppingCart_Header.click();
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
		if (table.getText().contains("MacBook Air")) 
		{
			Assert.assertEquals(table, true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	} */
	
	public void clk_remove_btn()
	{
		btn_remove.click();
	}
	
	public void msg_After_clk_removeBTN()
	{
		String expected_msg="Success: You have modified your wish list!";
		if (msg_After_clk_removeBTN.getText().contains(expected_msg)) 
		{
			Assert.assertTrue(true);
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}
	
}
