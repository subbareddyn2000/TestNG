package nov25;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class VerifyAsserts1 {
WebDriver x;
String expected ="";
String actual ="";
@BeforeMethod
public void setUp()
{
	x=new ChromeDriver();
	x.manage().window().maximize();
	x.get("http://facebook.com");
	x.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Test
public void VerifTitle1()
{
	expected = "facebook";
	actual = x.getTitle();
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
	expected = "facebook";
	actual = x.getTitle();
	try {
		Assert.assertTrue(expected.equalsIgnoreCase(actual),"Title is Not Matching");
	}catch (Throwable t) 
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

