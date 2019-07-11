package com.unicefuk.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unicefuk.pages.ItemDetailPage;
import com.unicefuk.base.BasePageObject;

public class C3category extends BasePageObject {
	
	private static final By productPlate = By.xpath("//*[@id='product-list']/div/div");

	public C3category(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/* Open c3 page given link*/
	public void openC3pageURL( String c3link ) {
		System.out.println("Opening c3 page : " + c3link);
		getPage(c3link);
	}
	
	/* wait for c3 to load */
	public void waitForC3toLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}
	
	/* Get productID of given productPlate */
	public String getProductID(Integer randomeProductPlateNumber) {
		 By currentProductLinkField = By.xpath("//div[@id='product-list']/div/div["+randomeProductPlateNumber+"]/a");
		 String productUrl =  driver.findElement(currentProductLinkField).getAttribute("href");
		 productUrl = (productUrl.split("/")[productUrl.split("/").length - 1]).substring(1);
		return productUrl;
	}
	
	/* to click on random products in category page */
	public ItemDetailPage clickProductPlateRandom(Integer randomeProductPlateNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//div[@id='product-list']/div/div["+randomeProductPlateNumber+"]/a");
		click(currentproductPlateField);
		return new ItemDetailPage(driver);
	}
	
	/* to get total product count */
	
	public void totlaProduct() throws Exception{
		
		List<WebElement> products = driver.findElements(By.xpath(""));	
		Integer value= products.size();
		System.out.println(value);
	}

}
