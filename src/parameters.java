import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class parameters {

	static WebDriver driver = new ChromeDriver();
	static Random rand = new Random();
	static String firstName = RandomStringUtils.randomAlphabetic(5);
	static String lastName = RandomStringUtils.randomAlphabetic(5);

	static String URL = "https://www.saucedemo.com/";

	static public void Login(String username, String password){

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

	}

	static public void ChooseItemFullProcess() throws InterruptedException {

		List<WebElement> buttons = driver.findElements(By.className("btn_primary"));
//		int randInt = rand.nextInt(buttons.size());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).click();
		}

		Thread.sleep(1000);

		driver.findElement(By.className("shopping_cart_link")).click();

		Thread.sleep(1000);
		driver.findElement(By.id("checkout")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("first-name")).sendKeys(firstName);

		driver.findElement(By.id("last-name")).sendKeys(lastName);

		driver.findElement(By.id("postal-code")).sendKeys("1356");

		Thread.sleep(1000);

		driver.findElement(By.id("continue")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("finish")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String Message = driver.findElement(By.className("complete-header")).getText();
		Assert.assertEquals("Thank you for your order!", Message);
	}

}
