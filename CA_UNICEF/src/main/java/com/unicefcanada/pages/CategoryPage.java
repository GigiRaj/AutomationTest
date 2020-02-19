package com.unicefcanada.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicefcanada.base.BasePageObject;
import com.unicefcanada.pages.ItemDetailPage;

public class CategoryPage extends BasePageObject {

	public CategoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By productplate= By.xpath("//*[@id='product-listing-container']/form[2]/ul/li");

	/* wait for category page to load */
	public void waitForCategorytoLoad() throws Exception {
		waitForJavascripttoLoad();
	}

	/* method for extracting product id from URL */
	public String URLExtract(String url) throws Exception {
		url = url.substring(0, url.length() - 1);
		String last = url.substring(url.lastIndexOf("/") + 1);
		System.out.println(last);
		return last;
	}
	
	/* to get Product count */
	public int getproductCount(){
		return getFieldCount(productplate);
	}
	
	/* to get product id of selected product plate */
	public String getProductID(Integer randomProductPlateNumber) throws Exception{
		By currentProductlinkField = By.xpath("//*[@id='product-listing-container']/form[2]/ul/li[" + randomProductPlateNumber + "]/article/figure/a");
		String url = driver.findElement(currentProductlinkField).getAttribute("href");
		System.out.println(url);
		String productid= URLExtract(url);
		System.out.println(productid);
		return productid;
	}
	
	/* to click on product plate */
	public ItemDetailPage clickProductPlateRandom(Integer randomProductPlateNumber) throws Exception{
		By currentProductlinkField = By.xpath("//*[@id='product-listing-container']/form[2]/ul/li[" + randomProductPlateNumber + "]/article");
		click(currentProductlinkField);
		return new ItemDetailPage(driver);
	}

}
