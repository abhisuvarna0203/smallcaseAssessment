package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPageObj {
	WebDriver driver = null;
	WebDriverWait wait;

	public FlipkartPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@FindBy(how = How.XPATH, using = "//div[2]/div/div/button")
	public WebElement LoginXButton;

	@FindBy(how = How.XPATH, using = "//form/div/div/input")
	public WebElement SearchInputBox;

	@FindBy(how = How.XPATH, using = "//div/div[1]/div[1]/div[2]/div[2]/form/ul/li[1]/div")
	public WebElement FirstInList;

	@FindBy(how = How.XPATH, using = "(//div[@class='_30jeq3 _1_WHN1'])[1]")
	public WebElement FirstItemPrice;

	@FindBy(how = How.XPATH, using = "(//a/div[2]/div[1]/div[1])[1]")
	public WebElement ClickFirstItem;

	@FindBy(how = How.XPATH, using = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	public WebElement AddToCart;

	@FindBy(how = How.XPATH, using = "//div/button[2]")
	public WebElement IncreaseQuantity;

	@FindBy(how = How.XPATH, using = "//div/span/div/div/span")
	public WebElement PriceAfterIncreasedQuantity;

	@FindBy(how = How.XPATH, using = "//div[@class='_2sKwjB']")
	public WebElement IncreasedQtyAddedMsg;

	public void CloseLoginOption() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginXButton)).click();
	}

	public void IncreaseQuantity() {
		wait.until(ExpectedConditions.elementToBeClickable(IncreaseQuantity)).click();
		wait.until(ExpectedConditions.visibilityOf(IncreasedQtyAddedMsg));
	}

}