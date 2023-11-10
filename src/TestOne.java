import org.testng.annotations.Test;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestOne extends parameters {
	@BeforeMethod
	public void Setup() {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@Test
	public void TestLogin() throws InterruptedException {
		Login("standard_user", "secret_sauce");
		ChooseItemFullProcess();
	}

	@AfterTest
	public void POstTesting() {

	}
}
