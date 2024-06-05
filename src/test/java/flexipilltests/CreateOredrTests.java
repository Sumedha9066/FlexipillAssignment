package flexipilltests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

public class CreateOredrTests {
	WebDriver wd;
	LoginPage loginPage;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sumedha\\OneDrive\\Desktop\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary(new File("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"));

		wd = new ChromeDriver(options);
		wd.get("https://flexipill-ui-new-staging.vercel.app/");
		if (!wd.getWindowHandles().isEmpty()) {
			wd.manage().window().maximize();
		} else {
			System.out.println("No window handles available.");
		}

		loginPage = new LoginPage(wd);

		loginPage.clickOnLoginButton();
		loginPage.enterUserPhoneNumber("1111111111");
		loginPage.clickOnContinue();
		loginPage.enterOtp("1", "1", "1", "1");

	}

	public void addToCartDetails() throws InterruptedException {
		addToCart addToCart = new addToCart(wd);

		addToCart.selectingDigestive();
		addToCart.selectingPentab();
		addToCart.clickOnCartDetails();
		addToCart.dropDown();

	}

	@Test
	public void placeOrderDetails() throws InterruptedException {
		addToCart addToCart = new addToCart(wd);

		addToCart.selectingDigestive();
		addToCart.selectingPentab();
		addToCart.clickOnCartDetails();
		addToCart.dropDown();
		placeOrder placeOrder = new placeOrder(wd);
		placeOrder.selectingCashOnDelivery();
		placeOrder.ClickOnPlaceOrder();
		placeOrder.verifingTheOrderDetails();

	}

	@AfterSuite
	public void afterSuite() {
		wd.quit();
	}

}
