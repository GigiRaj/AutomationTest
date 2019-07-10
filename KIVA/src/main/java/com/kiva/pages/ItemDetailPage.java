package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.kiva.base.BasePageObject;

public class ItemDetailPage extends BasePageObject{
	
	public ItemDetailPage(WebDriver driver) {
		super(driver);
		}
	
	private By productIDField = By.xpath("//*[@id='productpic-box' ]/div/img");
	private By originalPriceField = By.xpath("//*[@id='itempricing']/p/strong");
	private By attribSelectDropdown = By.xpath("//*[@id='attb']");
	private By attribSelect = By.xpath("//div[@id='attributeoptions']");
	private By AddToCartButtonField = By.id("btn-addtocart");
	private By isAttributeField = By.xpath("//form[@name='addtocart']/input[@name='AttribYes']");
	private By gotocart = By.xpath("//*[@id='cart-flyout']/a");
	
	
	public void waitForItemDetailLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get productID of given productPlate */
	public String getProductID() {
		return find(productIDField).getAttribute("data-productid");
	}
	
	public String getProductPrice() {
		String originalPrice = getText(originalPriceField);
		//int orgpric =Integer.parseInt(originalPrice);
		return originalPrice;
	}
	
	public void clickAddToCartButton() throws Exception {
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
		explicitWait(AddToCartButtonField);
		waitForClickabilityOf(AddToCartButtonField, 10);
		click(AddToCartButtonField);
	}
	
	public Boolean isAttribute() {
		int isAttrib = Integer.parseInt(find(isAttributeField).getAttribute("value"));
		if (isAttrib == 0) {
			return false;
		}
		return true;
	}
	

	public void Gotocart() throws Exception
	{
	explicitWait(gotocart);
	waitForClickabilityOf(gotocart, 30);
	click(gotocart);
	}
	
}
