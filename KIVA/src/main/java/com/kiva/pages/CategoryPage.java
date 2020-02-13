package com.kiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.kiva.base.BasePageObject;
import com.kiva.pages.ItemDetailPage;

public class CategoryPage extends BasePageObject {
	
	public CategoryPage(WebDriver driver) {
		super(driver);
		}
	
	private static final By productPlate = By.xpath("//*[@id='product-list']/div/div");
	
	
	/* wait for category page to load */
	public void waitForCategorytoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}
	
	/* Get productID of given productPlate */
	public String getProductID(Integer randomeProductPlateNumber) {
		 By currentProductLinkField = By.xpath("//*[@id='product-list']/div/div["+ randomeProductPlateNumber + "]/a[1]");
		return driver.findElement(currentProductLinkField).getAttribute("data-linkproductid");
	}
	
	public ItemDetailPage clickProductPlateRandom(Integer randomeProductPlateNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//*[@id='product-list']/div/div["+ randomeProductPlateNumber + "]/a[1]");
		click(currentproductPlateField);
		return new ItemDetailPage(driver);
	}


}
