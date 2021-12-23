package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.Status;

import extentreports.TestListeners;

public class ContactPage extends TestListeners{
	
	public ContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Contact']")
	public WebElement contactLink;
	
	@FindBy(id="forename")
	public WebElement fname;
	
	@FindBy(id="surname")
	public WebElement lname;
	
		
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "telephone")
	public WebElement phnum;
	
	@FindBy(id = "message")
	public WebElement message;
	
	@FindBy(xpath = "//a[text()='Submit']")
	public WebElement submit;
	
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	public WebElement alert;
	
	public void clickOnContact() {
		extentTest.get().log(Status.INFO, "Clicking on contact");
		contactLink.click();
	}
	
	
	
	public void enterFname(String forename) {
		extentTest.get().log(Status.INFO, "Entering Firstname "+forename);
		fname.sendKeys(forename);
		
	}
	
	public void enterlname(String lastname) {
		extentTest.get().log(Status.INFO, "Entering Firstname "+lastname);
		lname.sendKeys(lastname);
		
	}
	
	public void enterEmail(String emailadd) {
		extentTest.get().log(Status.INFO, "Entering Firstname "+emailadd);
		email.sendKeys(emailadd);
		
	}
	
	public void enterPhoneNumber(String phonenum) {
		extentTest.get().log(Status.INFO, "Entering Firstname "+phonenum);
		phnum.sendKeys(phonenum);
		
	}
	
	public void enterMessage(String msg) {
		extentTest.get().log(Status.INFO, "Entering Firstname "+msg);
		message.sendKeys(msg);
		
	}
	
	public void submitFeedback() {
		extentTest.get().log(Status.INFO, "Submitting Feedback");
		submit.click();
		
	}
	
	public String submitMessage() {
		String text = alert.getText();
		return text;
	}

}
