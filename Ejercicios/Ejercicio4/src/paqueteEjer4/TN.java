package paqueteEjer4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TN {
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
		// TODO Auto-generated method stub
	}	@Test(
			description = "Ejercicio4"
				)
		public void ejercicio4() {
		driver.get ("http://tn.com.ar");
		WebElement Noticia = driver.findElement(By.xpath("//article[@id='big-header']"));
		Noticia.click();
		WebElement Coments = driver.findElement(By.className("comments"));
		Assert.assertTrue(Coments.getText()!="0", "la noticia posee mas de un comentario");

		
		
		
	}

}
//Ingresar a www.tn.com.ar, cargar una noticia, apretar en el botón de cargar
//comentarios y controlar si la cantidad es mayor a 1