package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import extentreports.TestListeners;

public class StartShoppingPage extends TestListeners {

	public StartShoppingPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[text()='Start Shopping »']")
	public WebElement shoppingLink;

	@FindBy(xpath = "//*[text()='Buy']")
	public List<WebElement> buy;

	@FindBy(xpath = "//*[@id='nav-cart']/a")
	public WebElement cart;

	@FindBy(xpath = "//*[@class='table table-striped cart-items']/tbody/tr/td[2]")
	public List<WebElement> price;

	@FindBy(xpath = "//*[@class='table table-striped cart-items']/tbody/tr/td[3]")
	public List<WebElement> quantity;

	@FindBy(xpath = "//*[@class='table table-striped cart-items']/tbody/tr/td[4]")
	public List<WebElement> subtotal;

	public void clickOnShoppingLink() {
		extentTest.get().log(Status.INFO, "Clicking on Shop");
		shoppingLink.click();
	}

	public void clickOnStuffedFrogBuyButton() {

		extentTest.get().log(Status.INFO, "Clicking on Stuffed Frog");
		for (int i = 0; i < 2; i++) {
			buy.get(1).click();

		}

	}

	public void clickOnFluffyBunnyBuyButton() {

		extentTest.get().log(Status.INFO, "Clicking on Stuffed Frog");
		for (int i = 0; i < 5; i++) {
			buy.get(3).click();

		}

	}

	public void clickOnValentineBearBuyButton() {

		extentTest.get().log(Status.INFO, "Clicking on Stuffed Frog");
		for (int i = 0; i < 3; i++) {
			buy.get(6).click();

		}

	}

	public void clickOnCart() {
		extentTest.get().log(Status.INFO, "Clicking on Cart");
		cart.click();

	}
	
	//Sub total Verification
	public void verifySubtotal(int index, int quantity) {
		String price1 = price.get(index).getText().substring(1);
		Double quantityPrice = Double.parseDouble(price1) * quantity;
		System.out.println(quantityPrice);
		String subTotalPrice = subtotal.get(index).getText().substring(1);
		Double subtotal = Double.parseDouble(subTotalPrice);
		System.out.println(subtotal);
		Assert.assertEquals(subtotal, quantityPrice);

	}

	public void verifySubtotalForStuffedFrog() {
		extentTest.get().log(Status.INFO, "Verifying Subtotal For Stuffed Frog");
		verifySubtotal(0, 2);
	}

	public void verifySubtotalForFluffyBunny() {
		extentTest.get().log(Status.INFO, "Verifying Subtotal For Fluffy Bunny");
		verifySubtotal(1, 5);
	}

	public void verifySubtotalForValentineBear() {
		extentTest.get().log(Status.INFO, "Verifying Subtotal For Valentine Bear");
		verifySubtotal(2, 3);
	}

}
