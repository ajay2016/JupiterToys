package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import extentreports.TestListeners;
import utilities.ExcelReader;

public class BaseTest extends TestListeners {

	public WebDriver driver;
	public SoftAssert softAssert;
	public static Properties prop = new Properties();
	public FileInputStream fis;
	public static ExcelReader excel;

	@BeforeClass
	public void setUp() {

		excel = new ExcelReader(".\\src\\test\\resources\\testdata\\testdata.xlsx");
		// prop= new Properties();
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterClass() {
		if (driver != null)
			driver.quit();

	}

	public void openBrowser(String browserType) throws IOException {

		extentTest.get().log(Status.INFO, "Opening " + browserType + " Browser");
		

			if (browserType.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver = new ChromeDriver(options);

			} else if (browserType.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
				driver = new FirefoxDriver();

			} else if (browserType.equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else if (browserType.equals("Edge")) {
				System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
				System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, "null");
				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	

	public void navigate(String urlKey) {

		extentTest.get().log(Status.INFO, "Navigate to " + urlKey);
		driver.get(prop.getProperty(urlKey));
		

	}

	public void closeBrowser() {
		extentTest.get().log(Status.INFO, "Closing Browser");

	}
	
	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForVisibilityOfElement(WebElement e) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	
}
