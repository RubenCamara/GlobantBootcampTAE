
package paqueteejer2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Mail {
	private WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context){
	try {
	driver = new FirefoxDriver();
		} catch (Exception e) {
	}
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context){
	try {
	driver.close();
	driver.quit();
		} catch (Exception e) {}
}

	@Test(
		description = "Ejercicio2"
			)
	public void ejercicio2() {
		driver.get ("http://www.hotmail.com");
		driver.manage().window().maximize();
		WebElement User = driver.findElement(By.xpath("//input[@id='i0116']"));

		User.sendKeys("rubencamara2@outlook.es");
		WebElement Pass = driver.findElement(By.xpath("//input[@id='i0118']"));
		Pass.sendKeys("Rubencito14");
		WebElement Logear = driver.findElement(By.xpath("//input[@id='idSIButton9']"));
		Logear.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Mail = driver.findElement(By.xpath("//*[@id='_ariaId_26']"));
	
		Mail.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement Correo = driver.findElement(By.xpath("//button[@class = 'ms-border-color-neutralTertiary ms-border-color-black-hover _rp_37 o365button']"));
		Correo.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement Remitente = driver.findElement(By.xpath("//span[@class='_pe_l _pe_K']"));
		String Remi= Remitente.getText();
		//String Remitente = driver.findElement(By.xpath("//*[@id='_pe_c']")).getText();
		
		Assert.assertTrue(Remi.contains("support@hotmail.com"), "el remitente es el soporte");
		System.out.println(Remitente);
	
}
}


