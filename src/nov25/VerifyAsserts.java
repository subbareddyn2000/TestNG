package nov25;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class VerifyAsserts {
	WebDriver x;
	String expected="";
	String actual = "";
	@BeforeMethod
	public void setUp()
	{
		x = new ChromeDriver();
		x.manage().window().maximize();
		x.get("http://Google.com");
		x.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void verifyTitle1()
	{
		expected = "Google";
		actual =x.getTitle();
		try {
			Assert.assertEquals(expected, actual,"Title is Not Matching");
		}catch (Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
	@Test
	public void verifyTitle2()
	{
		expected ="Google";
		actual = x.getTitle();
		try {
			Assert.assertTrue(expected.equalsIgnoreCase(actual), "Title is Not Matching");
		}catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
	@Test
	public void verifyTitle3()
	{
		expected ="Google";
		actual = x.getTitle();
		try {
			Assert.assertFalse(expected.equalsIgnoreCase(actual), "Title is Matching");
		}catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}
	@AfterMethod
	public void tearDown()
	{
		x.close();
	}
}

