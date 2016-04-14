package paquete;

import java.util.List;
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



public class Google {
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
	} catch (Exception e) {
	}
	}
	@Test(description = "Ejercicio3"
			)
	public void ejercicio3() {
	
			
		driver.get("http://www.google.com");
		WebElement Cuadro = driver.findElement(By.xpath("//input[@id='lst-ib']"));
		Cuadro.sendKeys("Ejemplos");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement Buscar = driver.findElement(By.xpath("//*[@class='lsb']"));
		Buscar.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//List<WebElement> Result = driver.findElements(By.xpath("//*[@class='f kv _SWb']"));
		//List<WebElement> Result = driver.findElements(By.cssSelector(".kv"));
		WebElement Result = driver.findElement(By.cssSelector(".g:nth-of-type(3) .kv"));

		//String URLResult = Result.get(2).getText();
		String URLResult = Result.getText();
		driver.get(URLResult);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		Boolean Existe = driver.findElement(By.xpath("//*")) != null;
		Assert.assertTrue(Existe," hay elementos en esta pagina.");
		
	}// arreglar

}


//Ingresar a www.google.com, realizar una búsqueda, esperar a que carguen todos los
//resultados, clickear en el tercero, aguardar a que esa página cargue y controlar la
//existencia de algún elemento