package myAssessment;

import java.nio.file.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import methods.FirstScenario;
import methods.SecondScenario;

public class Runner {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				Paths.get("").toAbsolutePath().toString() + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FirstScenario firstScenario = new FirstScenario(driver);
		firstScenario.executeFirstScenario("iPhone Se");
		firstScenario.IncreaseFlipKartQuantity();
		firstScenario.PrintPriceinCart();
		driver.quit();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		SecondScenario secondScenario = new SecondScenario(driver);
		secondScenario.executeSecondScenario("samsung s21 ultra");
		driver.quit();
	}
}
