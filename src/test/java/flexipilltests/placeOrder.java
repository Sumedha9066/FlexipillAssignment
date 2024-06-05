package flexipilltests;

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class placeOrder {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	SoftAssert softAssert;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[5]/fieldset/div/div[1]/label/span[2]")
	WebElement selectingPaymentMode;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[6]/button")
	WebElement placingOrder;
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div[3]")
	WebElement orderDetails;
	
	
	public placeOrder(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softAssert = new SoftAssert();
		
	}
	
	public void selectingCashOnDelivery() throws InterruptedException {
		scrollToElement(driver, selectingPaymentMode);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(selectingPaymentMode));
		Thread.sleep(5000);
		selectingPaymentMode.click();
		
	}
	
	public void ClickOnPlaceOrder() {
		scrollToElement(driver, placingOrder);
		wait.until(ExpectedConditions.visibilityOf(placingOrder)).click();
		
	}
	public void verifingTheOrderDetails() throws InterruptedException {
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(orderDetails)).isDisplayed();
		softAssert.assertTrue(orderDetails.isDisplayed());
		
		
		
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

}
