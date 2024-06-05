package flexipilltests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(linkText = "Login")
	WebElement clickOnLogin;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div/input")
	WebElement userNumberField;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[3]/button/p")
	WebElement ContinueButton;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[3]/div[1]")
	WebElement otpField;

	@FindBy(xpath = "//*[@class=\"login-modal_otp_box__WPbVW\"]/div[1]/div[1]/input")
	WebElement otp1;

	@FindBy(xpath = "//*[@class=\"login-modal_otp_box__WPbVW\"]/div[2]/div[1]/input")
	WebElement otp2;

	@FindBy(xpath = "//*[@class=\"login-modal_otp_box__WPbVW\"]/div[3]/div[1]/input")
	WebElement otp3;

	@FindBy(xpath = "//*[@class=\"login-modal_otp_box__WPbVW\"]/div[4]/div[1]/input")
	WebElement otp4;

	@FindBy(linkText = "Submit OTP")
	WebElement clickOnSubmit;

	@FindBy(linkText = "Profile")
	WebElement profile;

	@FindBy(className = "logout-btn")
	WebElement logoutButton;

	public LoginPage(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnLogin));
		clickOnLogin.click();
	}

	public void enterUserPhoneNumber(String phoneNumber) {
		wait.until(ExpectedConditions.visibilityOf(userNumberField));
		userNumberField.sendKeys(phoneNumber);
	}

	public void clickOnContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(ContinueButton));
		ContinueButton.click();
	}

	public void enterOtp(String digitOne, String digittwo, String digitthree, String digitfour) {
		wait.until(ExpectedConditions.visibilityOf(otp1));

		otp1.sendKeys(digitOne);
		otp2.sendKeys(digittwo);
		otp3.sendKeys(digitthree);
		otp4.sendKeys(digitfour);
	}

	public boolean profileAssertion() {
		wait.until(ExpectedConditions.visibilityOf(profile));
		return profile.isDisplayed();

	}

	public void clickOnProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
		
	}
	
	public void clickOnLogout() {
		try {
			Thread.sleep(5000);
			scrollToElement(driver,logoutButton);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
//		scrollToElement(driver,logoutButton);
//		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		clickElement(driver,logoutButton); //.click();
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void clickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(true);", element);

	}
}
