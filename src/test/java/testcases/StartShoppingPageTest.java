package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.StartShoppingPage;
import utilities.DataUtil;

public class StartShoppingPageTest extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void startShoppingPage(Hashtable<String, String> data) throws IOException {
		
		
		
		if (!DataUtil.isRunnable("startShoppingPage") || data.get("Runmode").equals("N")) {

			
			throw new SkipException("Test skipped since rumode is N");

		}

		
		openBrowser(data.get("Browser"));

		navigate("appurl");
		
		StartShoppingPage sp = new StartShoppingPage(driver);
		sp.clickOnShoppingLink();
		sp.clickOnStuffedFrogBuyButton();
		sp.clickOnFluffyBunnyBuyButton();
		sp.clickOnValentineBearBuyButton();		
		sp.clickOnCart();
		
		//Verification
		sp.verifySubtotalForStuffedFrog();
		sp.verifySubtotalForFluffyBunny();
		sp.verifySubtotalForValentineBear();
		

	}

}
