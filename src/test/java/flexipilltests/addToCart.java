package flexipilltests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCart {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@FindBy(linkText = "Search")
	WebElement searchBarField;
	
	@FindBy(xpath = "/html/body/div/section[2]/div[2]/div[2]/a")
	WebElement clickOnDigestive;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div/a[1]/div/div[2]/div[2]/div/div/div[2]/button")
	WebElement addToCartButton;
	
	/*@FindBy(xpath = "/html/body/div/div[1]/div[2]/div/div/div/a[1]/div/div[2]/div[1]")
	WebElement clockOnTablet;*/
	
	@FindBy(xpath = "/html/body/div/header/div/div[2]/button/span/span")
	WebElement clickOnCart;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div/div[2]")
	WebElement itemCountDropdown;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[4]")
	WebElement itemIncrease;
	
	
	
	
	
	public addToCart(WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectingDigestive() {
		scrollToElement(driver, clickOnDigestive);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnDigestive));
		clickOnDigestive.click();
		
	}
	
	public void selectingPentab() throws InterruptedException {
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
		
	}
	
	public void clickOnCartDetails() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(clickOnCart)).click();
	
		
	}
		
	public void dropDown() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(itemCountDropdown)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(itemIncrease)).click();
		
	}
	
	
     
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
}
