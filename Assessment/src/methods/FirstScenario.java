package methods;

import org.openqa.selenium.WebDriver;

import pageObjects.FlipkartPageObj;

public class FirstScenario {
	WebDriver driver;
	CommonMethods common;
	FlipkartPageObj flipkartHomePage;

	public FirstScenario(WebDriver driver) {
		this.driver = driver;
		flipkartHomePage = new FlipkartPageObj(driver);
		common = new CommonMethods(driver);
	}

	public void executeFirstScenario(String itemName) {
		System.out.println("********Search Item in Flipkart********");
		driver.get("https://www.flipkart.com/");
		flipkartHomePage.CloseLoginOption();
		common.SearchAndClickItem(flipkartHomePage.SearchInputBox, itemName, flipkartHomePage.FirstInList);
		String message = "Price in Flipkart Search page : ";
		common.PrintItemPrice(flipkartHomePage.FirstItemPrice, flipkartHomePage.ClickFirstItem, "flipkart", message);
		common.AddItemToCart(flipkartHomePage.AddToCart);
	}

	public void IncreaseFlipKartQuantity() {
		flipkartHomePage.IncreaseQuantity();
	}

	public String PrintPriceinCart() {
		String message = "Price in Flipkart Cart : ";
		common.PrintItemPriceinCart(flipkartHomePage.IncreaseQuantity, flipkartHomePage.PriceAfterIncreasedQuantity,
				"flipkart", message);
		return flipkartHomePage.PriceAfterIncreasedQuantity.getText();
	}
}
