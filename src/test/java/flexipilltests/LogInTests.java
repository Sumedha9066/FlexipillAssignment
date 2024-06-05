package flexipilltests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTests {
	WebDriver wd;
	LoginPage loginPage;
	SoftAssert softAssert;

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sumedha\\OneDrive\\Desktop\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary(new File("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"));

		wd = new ChromeDriver(options);
		loginPage = new LoginPage(wd);
		softAssert = new SoftAssert();
		wd.get("https://flexipill-ui-new-staging.vercel.app/");
		if (!wd.getWindowHandles().isEmpty()) {
			wd.manage().window().maximize();
		} else {
			System.out.println("No window handles available.");
		}

	}

	@Test(priority =2)
	public void successfulLogin() {
		wd.get("https://flexipill-ui-new-staging.vercel.app/");
		loginPage.clickOnLoginButton();
		loginPage.enterUserPhoneNumber("1111111111");
		loginPage.clickOnContinue();
		loginPage.enterOtp("1","1","1","1");
		softAssert.assertTrue(loginPage.profileAssertion());

		loginPage.clickOnProfile();
		loginPage.clickOnLogout();
	}
	@AfterTest
	public void logout() {
		
	}

	@Test(priority = 1)
	public void invalidPhoneNumber() {
		wd.get("https://flexipill-ui-new-staging.vercel.app/");
		loginPage.clickOnLoginButton();
		loginPage.enterUserPhoneNumber("2274378886");
		softAssert.assertTrue(!loginPage.ContinueButton.isEnabled());
	}
	
	@AfterSuite
	public void quit() {
		wd.quit();
	}
	
}
