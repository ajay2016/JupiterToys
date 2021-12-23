package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.ShopPage;
import utilities.DataUtil;

public class ShopPageTest extends BaseTest {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void shopPage(Hashtable<String, String> data) throws IOException {
		
		
		
		if (!DataUtil.isRunnable("shopPage") || data.get("Runmode").equals("N")) {

			
			throw new SkipException("Test skipped since rumode is N");

		}

		
		openBrowser(data.get("Browser"));

		navigate("appurl");
		
		ShopPage sp = new ShopPage(driver);
		sp.clickOnShop();
		sp.clickOnFunnyCowBuyButton();
		sp.clickOnFluffyBunnyBuyButton();
		sp.clickOnCart();
		
		//Verification
		String text =sp.getFunnyCow();
		Assert.assertEquals(text, data.get("Item1"));
		String text1 = sp.getFluffyBunny();
		Assert.assertEquals(text1, data.get("Item2"));
		
		

	}

}
