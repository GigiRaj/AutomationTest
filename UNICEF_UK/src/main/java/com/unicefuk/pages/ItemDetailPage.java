package com.unicefuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.unicefuk.base.BasePageObject;

public class ItemDetailPage extends BasePageObject{
	
	
	private String URL = "https://market.unicef.org.uk/product/peridot-band-ring-king-cobra/E41638/";
	private By productIDField = By.xpath("//*[@id='productpic']/img");
	private By originalPriceField = By.xpath("//*[@id='itempricing']/p/strong");
	private By isAttributeField = By.xpath("//form[@name='addtocart']/input[@name='AttribYes']");
	private By attribSelectDropdown = By.xpath("//select[@id='attb']");
	private By attribSelect = By.xpath("//div[@id='attributeoptions']");
	private By AddToCartButtonField = By.id("btn-addtocart");
	private By cartPriceField = By.xpath("//div[@id='cart-flyout']/div/table/tbody/tr[3]/td[3]/span");
	private By gotocart = By.xpath("//*[@id='cart-flyout']/a");
	private By AddToWishlist= By.id("wishlistItem");
	

	public ItemDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void openDetailpage() { 
		getPage(URL);
	}
	
	public void waitForItemDetailLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get productID of given productPlate */
	public String getProductID() {
		return find(productIDField).getAttribute("data-productid");
	}
	
	/* Get original price from itemdetail page */
	public String getProductPrice() {
		String originalPrice = getText(originalPriceField);
		//int orgpric =Integer.parseInt(originalPrice);
		return originalPrice;
	}
	
	
	/* to click add to cart button according size and quantity */
	public void clickAddToCartButton() {
		if (isAttribute()) {
			Select drpAttrib = new Select(find(attribSelectDropdown));
			Integer size = drpAttrib.getOptions().size();
			Integer selectIndex = 1;
			for (Integer index = 1; index <= size; index++) {
				int useattribqty = Integer.parseInt(drpAttrib.getOptions().get(index).getAttribute("data-useattribqty").toString());
				if (useattribqty != 0) {
					selectIndex = index;
					break;
				}
			}
			selectIndex++;
			click(attribSelect);
			click(By.xpath("//select[@id='attb']/option[" + selectIndex + "]"));
		}
		waitForClickabilityOf(AddToCartButtonField, 10);
		click(AddToCartButtonField);
	}
	
	/* to click pn add to wishlist button according to size and quantity */
	public void clickAddToWishlistButton(){
		
		if(isAttribute()){
			Select drpAttrib= new Select(find(attribSelectDropdown));
			Integer size=drpAttrib.getOptions().size();
			Integer selectIndex=1;
			for(Integer index = 1; index <= size; index++)
			{
				int useattribqty=Integer.parseInt(drpAttrib.getOptions().get(index).getAttribute("data-useattribqty").toString());
				if(useattribqty != 0){
					selectIndex = index;
					break;
				}
			}
			selectIndex++;
			click(attribSelect);
			click(By.xpath("//select[@id='attb']/option[" + selectIndex + "]"));
		}
		waitForClickabilityOf(AddToWishlist,10);
		click(AddToWishlist);
	}
	
	public Boolean isAttribute() {
		int isAttrib = Integer.parseInt(find(isAttributeField).getAttribute("value"));
		if (isAttrib == 0) {
			return false;
		}
		return true;
	}
	
	public void waitForCartFlyoutToload() {
		waitForVisibilityOf(cartPriceField, 30);
	}
	
	/* to click on Add to bag button on top */
	public void Gotocart()
		{
		waitForClickabilityOf(gotocart, 30);
		click(gotocart);
		}

}
