package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobjects.ContactPage;
import utilities.DataUtil;

public class ContactPageTest extends BaseTest {
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void contactPage(Hashtable<String, String> data) throws IOException {

		if (!DataUtil.isRunnable("contactPage") || data.get("Runmode").equals("N")) {

			throw new SkipException("Test skipped since rumode is N");

		}

		openBrowser(data.get("Browser"));

		navigate("appurl");

		ContactPage cp = new ContactPage(driver);
		cp.clickOnContact();
		cp.enterFname(data.get("FirstName"));
		cp.enterlname(data.get("LastName"));
		cp.enterEmail(data.get("Email"));
		cp.enterPhoneNumber(data.get("PhoneNumber"));
		cp.enterMessage(data.get("Message"));
		cp.submitFeedback();

		// Validation Successful Submission
		waitForVisibilityOfElement(cp.alert);
		String text = cp.submitMessage();
		System.out.println(text);
		Assert.assertEquals(text, data.get("Alert Message"));

	}
}
