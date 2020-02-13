package com.healthebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.healthebay.base.BasePageObject;

public class ItemDetailPage extends BasePageObject {

	public ItemDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By productIDField = By.xpath("//div[1]/section[2]/figure/div/a/img");
	private By originalPriceField = By.xpath("//div[1]/section[1]/div/div[2]/div[3]/span[3]");
//	private By attribSelectDropdown = By.xpath("//*[@id='attb']");
//	private By attribSelect = By.xpath("//div[@id='attributeoptions']");
	private By AddToCartButtonField = By.id("form-action-addToCart");
	private By gotocart = By.xpath("//*[@id='previewModal']/div[1]/div[2]/div/section[1]/a[3]");
	private By chooseSizeDropdown = By.xpath("//form[1]/div/div/select[1]");
	
	public void waitForItemDetailLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	public String getProductPrice() {
		String originalPrice = getText(originalPriceField);
		//int orgpric =Integer.parseInt(originalPrice);
		return originalPrice;
	}
	
	public void Gotocart() throws Exception
	{
	explicitWait(gotocart);
	waitForClickabilityOf(gotocart, 30);
	click(gotocart);
	}
	

	
	public void clickAddToCartButton() throws Exception {
		
		if(driver.findElements(chooseSizeDropdown).size() != 0) {
			System.out.println("true condition");
			Select drpAttrib = new Select(find(chooseSizeDropdown));
			Integer size = drpAttrib.getOptions().size();
			System.out.println(size);
			Integer selectIndex = 1;
			for (Integer index = 1; index <= size; index++) {
				int useattribqty = Integer.parseInt(drpAttrib.getOptions().get(index).getAttribute("data-product-attribute-value").toString());
				System.out.println(useattribqty);
				if (useattribqty != 0) {
					selectIndex = index;
					break;
				}
			}
			selectIndex++;
			click(chooseSizeDropdown);
			click(By.xpath("//form[1]/div/div/select/option[" + selectIndex + "]"));
		}
	
		System.out.println("false condition");
		explicitWait(AddToCartButtonField);
		waitForClickabilityOf(AddToCartButtonField, 10);
		click(AddToCartButtonField);
		System.out.println("clicked add to cart button");
	}
	

}
