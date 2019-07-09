package testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kiva.base.BaseTest;
import com.kiva.pages.HomePage;

public class CrticalPathFlow extends BaseTest {
	
	@Parameters("browser")
	@Test(priority=0)
	public void typeandsearch(String keyword) throws Exception {
		
		HomePage homePage = new HomePage(driver);
		homePage.openHomePage();
		
	}

}
