package methods;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	WebDriver driver;
	WebDriverWait wait;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20, 2000);
	}

	public void PrintItemPrice(WebElement FirstItemPrice, WebElement ClickFirstItem, String origin, String message) {
		wait.until(ExpectedConditions.visibilityOf(FirstItemPrice));
		String itemPrice = FirstItemPrice.getText();
		if (origin.equalsIgnoreCase("flipkart")) {
			itemPrice = itemPrice.substring(1);
			System.out.println(message + itemPrice);
		} else
			System.out.println(message + itemPrice);

		wait.until(ExpectedConditions.elementToBeClickable(ClickFirstItem)).click();
	}

	public String PrintItemPriceinCart(WebElement IncreaseQuantity, WebElement PriceAfterIncreasedQuantity,
			String origin, String message) {
		wait.until(ExpectedConditions.elementToBeClickable(IncreaseQuantity)).click();
		String itemPrice = PriceAfterIncreasedQuantity.getText();
		if (origin.equalsIgnoreCase("flipkart")) {
			itemPrice = itemPrice.substring(1);
			System.out.println(message + itemPrice);
		} else
			System.out.println(message + itemPrice);
		return itemPrice;
	}

	public void AddItemToCart(WebElement AddToCart) {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(newTb.size() - 1));
		wait.until(ExpectedConditions.visibilityOf(AddToCart));
		AddToCart.click();
	}

	public void SearchAndClickItem(WebElement SearchBar, String itemName, WebElement FirstItemInList) {
		wait.until(ExpectedConditions.visibilityOf(SearchBar)).click();
		SearchBar.sendKeys(itemName);
		wait.until(ExpectedConditions.visibilityOf(FirstItemInList));
		FirstItemInList.click();
		Actions act = new Actions(driver);
		act.moveToElement(SearchBar);
		act.perform();

	}

}
