package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import extentreports.TestListeners;

public class ShopPage extends TestListeners {

	public ShopPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Shop']")
	public WebElement shopLink;

	@FindBy(xpath = "//*[text()='Buy']")
	public List<WebElement> buy;

	@FindBy(xpath = "//*[@class='table table-striped cart-items']/tbody/tr/td[1]")
	public List<WebElement> items;

	@FindBy(xpath = "//*[@class='table table-striped cart-items']/tbody/tr/td[3]")
	public List<WebElement> quantity;

	@FindBy(xpath = "//*[@id='nav-cart']/a")
	public WebElement cart;

	
	
	public void clickOnShop() {
		extentTest.get().log(Status.INFO, "Clicking on Shop");
		shopLink.click();
	}

	public void clickOnFunnyCowBuyButton() {

		extentTest.get().log(Status.INFO, "Clicking on Funny Cow");
		for (int i = 0; i < 2; i++) {
			buy.get(5).click();
		}

	}

	public void clickOnFluffyBunnyBuyButton() {

		extentTest.get().log(Status.INFO, "Clicking on Fluffy Bunny");
		buy.get(3).click();

	}

	public void clickOnCart() {
		extentTest.get().log(Status.INFO, "Clicking on Cart");
		cart.click();

	}

	public String getFunnyCow() {
		extentTest.get().log(Status.INFO, "Verifying Funny Cow Presence");
		String text = items.get(0).getText();
		return text;

	}

	public String getFluffyBunny() {
		extentTest.get().log(Status.INFO, "Verifying Fluffy Bunny Presence");
		String text = items.get(1).getText();
		return text;

	}

}
