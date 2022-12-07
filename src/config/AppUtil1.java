package config;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class AppUtil1 {
	public static WebDriver driver;
	@BeforeSuite
	public static void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://calc.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Running precondition",true);
	}
	@AfterSuite
	public static void tearDown() throws Throwable
	{
		Reporter.log("Running post condition",true);
		Thread.sleep(3000);
		driver.close();
	}
}
