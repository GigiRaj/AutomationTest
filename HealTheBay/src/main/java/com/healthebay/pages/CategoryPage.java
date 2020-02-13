package com.healthebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.healthebay.base.BasePageObject;
import com.healthebay.pages.ItemDetailPage;

public class CategoryPage extends BasePageObject {

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By productPlate = By.xpath("//*[@id='product-listing-container']/form/ul/li");

	/* wait for category page to load */
	public void waitForCategorytoLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* method for extracting product id from URL */
	public String URLextract(String url)throws Exception{
	
		url =  url.substring(0, url.length() - 1);
		String last= url.substring(url.lastIndexOf("/") + 1);
		System.out.println(last);
		return last;
	} 

	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}

	/* Get productID of given productPlate */
	public String getProductID(Integer randomeProductPlateNumber) throws Exception {
		By currentProductLinkField = By.xpath("//*[@id='product-listing-container']/form/ul/li[" + randomeProductPlateNumber + "]/article/figure/a[1]");
		String url= driver.findElement(currentProductLinkField).getAttribute("href");
		System.out.println(url);
		String productid= URLextract(url);
		return productid;
	}

	public ItemDetailPage clickProductPlateRandom(Integer randomeProductPlateNumber) throws Exception {
		By currentproductPlateField = By.xpath("//*[@id='product-listing-container']/form/ul/li[" + randomeProductPlateNumber + "]/article");
		click(currentproductPlateField);
		return new ItemDetailPage(driver);
	}

}
