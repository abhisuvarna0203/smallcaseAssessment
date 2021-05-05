package methods;

import org.openqa.selenium.WebDriver;

import pageObjects.AmazonPageObj;

public class SecondScenario {
	WebDriver driver;
	AmazonPageObj amazonTest;
	FirstScenario flipKartTest;
	CommonMethods common;

	public SecondScenario(WebDriver driver) {
		this.driver = driver;
		amazonTest = new AmazonPageObj(driver);
		flipKartTest = new FirstScenario(driver);
		common = new CommonMethods(driver);
	}

	public void executeSecondScenario(String itemName) {
		String flipKartPrice = "", amazonPrice = "";
		flipKartTest.executeFirstScenario(itemName);
		flipKartPrice = flipKartTest.PrintPriceinCart();
		System.out.println("********Search Item in Amazon********");
		driver.get("https://www.amazon.in/");
		amazonTest.setPinCode();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		common.SearchAndClickItem(amazonTest.SearchBar, itemName, amazonTest.FirstItemInList);
		String message = "Price in Amazon Search page : ";
		common.PrintItemPrice(amazonTest.FirstItemPrice, amazonTest.FirstItem, "amazon", message);
		common.AddItemToCart(amazonTest.AddToCart);
		message = "Price in Amazon Cart : ";
		amazonPrice = common.PrintItemPriceinCart(amazonTest.MoveToCart, amazonTest.PriceInCart, "amazon", message);
		ComparePrice(flipKartPrice, amazonPrice);
	}

	private void ComparePrice(String fkPrice, String anPrice) {
		int flipKartPrice = Integer.parseInt(fkPrice.replaceAll("[^a-zA-Z0-9]", ""));
		anPrice = anPrice.strip().split("\\.")[0].replaceAll("[^a-zA-Z0-9]", "");
		int amazonPrice = Integer.parseInt(anPrice);
		if (flipKartPrice == amazonPrice)
			System.out.println("Prices same in both flipkart and amazon");
		else if (flipKartPrice < amazonPrice)
			System.out.println("Price in Flipkart cheaper by Rs " + (amazonPrice - flipKartPrice));
		else
			System.out.println("Price in Amazon cheaper by Rs " + (flipKartPrice - amazonPrice));
	}

}