package nov22;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PropertyFilefb {
	public Properties p;
	WebDriver x;
	@BeforeTest
	public void setup() throws Throwable
	{
		p = new Properties();
		p.load(new FileInputStream("D:\\Subbu\\TestNG_Frameworks\\Facebook.properties"));
		x = new ChromeDriver();
		x.manage().window().maximize();
		x.get(p.getProperty("url"));
		x.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void ValidateCreate()
	{
		x.findElement(By.xpath(p.getProperty("objcreate"))).click();
		x.findElement(By.xpath(p.getProperty("objfirst"))).sendKeys(p.getProperty("objfirstname"));
		x.findElement(By.xpath(p.getProperty("objsur"))).sendKeys(p.getProperty("objsurname"));
		x.findElement(By.xpath(p.getProperty("objmail"))).sendKeys(p.getProperty("objemail"));
		x.findElement(By.xpath(p.getProperty("objreentermail"))).sendKeys(p.getProperty("objreenteremail"));
		x.findElement(By.xpath(p.getProperty("objpass"))).sendKeys(p.getProperty("objpassword"));
		new Select(x.findElement(By.xpath(p.getProperty("objday")))).selectByIndex(3);
		new Select(x.findElement(By.xpath(p.getProperty("objmonth")))).selectByVisibleText(p.getProperty("objselectmonth"));
		new Select(x.findElement(By.xpath(p.getProperty("objyear")))).selectByIndex(20);        
		x.findElement(By.xpath(p.getProperty("objgender"))).click();
		x.findElement(By.xpath(p.getProperty("objsignup"))).click();
	}
	@AfterTest
	public void tearDown()
	{
		x.close();
	}
}
