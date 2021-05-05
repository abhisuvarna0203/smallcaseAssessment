package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPageObj {
	WebDriver driver = null;
	WebDriverWait wait;

	public AmazonPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(how = How.XPATH, using = "//span[@id='glow-ingress-line1']")
	public WebElement SetLocation;

	@FindBy(how = How.XPATH, using = "//input[@id='GLUXZipUpdateInput']")
	public WebElement PinCode;

	@FindBy(how = How.XPATH, using = "//span[@id='GLUXZipUpdate']")
	public WebElement Apply;

	@FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
	public WebElement SearchBar;

	@FindBy(how = How.XPATH, using = "//div[@id='a-popover-3']")
	public WebElement PopUp;

	@FindBy(how = How.XPATH, using = "//div[@id='suggestions']/div")
	public WebElement FirstItemInList;

	@FindBy(how = How.XPATH, using = "(//a/span[contains(text(),'S21 Ultra')])[1]/../../../../div[3]//a/span[1]/span[2]/span[2]")
	public WebElement FirstItemPrice;

	@FindBy(how = How.XPATH, using = "(//a/span[contains(text(),'S21 Ultra')])[1]")
	public WebElement FirstItem;

	@FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button']")
	public WebElement AddToCart;

	@FindBy(how = How.XPATH, using = "//span[@id='attach-sidesheet-view-cart-button']")
	public WebElement MoveToCart;

	@FindBy(how = How.XPATH, using = "//div[4]/div/div[2]/p/span")
	public WebElement PriceInCart;

	@FindBy(how = How.XPATH, using = "//div/div/div/div[3]/a/i")
	public WebElement NextArrow;

	public void setPinCode() {
		wait.until(ExpectedConditions.visibilityOf(SetLocation)).click();
		wait.until(ExpectedConditions.visibilityOf(PinCode)).sendKeys("560098");
		Apply.click();
		wait.until(ExpectedConditions.elementToBeClickable(NextArrow));
	}
}
