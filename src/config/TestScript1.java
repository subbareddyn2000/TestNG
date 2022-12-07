package config;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class TestScript1 extends AppUtil1{
	@Test(priority = 2)
	public void addition() 
	{
		driver.findElement(By.name("display")).sendKeys("98987");
		driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
		driver.findElement(By.name("display")).sendKeys("9898");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Executing Addition test",true);
	}
	@Test(priority = 1,enabled = false)
	public void division() 
	{
		driver.findElement(By.name("display")).sendKeys("98987");
		driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
		driver.findElement(By.name("display")).sendKeys("9898");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Executing division test",true);
	}
	@Test(priority = 0,invocationCount = 3)
	public void multiplication() 
	{
		driver.findElement(By.name("display")).sendKeys("98987");
		driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
		driver.findElement(By.name("display")).sendKeys("9898");
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		Reporter.log("Executing division test",true);
	}
}
