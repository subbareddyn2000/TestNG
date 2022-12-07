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
public class PropertyFile {
	public Properties p;
	WebDriver x;
	@BeforeTest
	public void setup() throws Throwable
	{
		p = new Properties();
		p.load(new FileInputStream("D:\\Subbu\\TestNG_Frameworks\\Flight.properties"));
		x = new ChromeDriver();
		x.manage().window().maximize();
		x.get(p.getProperty("Url"));
		x.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void ValidateRegister()
	{
		x.findElement(By.xpath(p.getProperty("objReg"))).click();
		x.findElement(By.xpath(p.getProperty("objName"))).sendKeys(p.getProperty("objentername"));
		x.findElement(By.xpath(p.getProperty("objContact"))).sendKeys(p.getProperty("objentercontact"));
		x.findElement(By.xpath(p.getProperty("objEmail"))).sendKeys(p.getProperty("objentermail"));
		x.findElement(By.xpath(p.getProperty("objpass"))).sendKeys(p.getProperty("objenterpass"));
		new Select(x.findElement(By.xpath(p.getProperty("objGender")))).selectByVisibleText(p.getProperty("objselectgender"));
		x.findElement(By.xpath(p.getProperty("objbirth"))).click();
		x.findElement(By.xpath(p.getProperty("objdate"))).click();
		x.findElement(By.xpath(p.getProperty("objcheckbox"))).click();
		x.findElement(By.xpath(p.getProperty("objregister"))).click();
	}
	@AfterTest
	public void tearDown()
	{
		x.close();
	}
}
