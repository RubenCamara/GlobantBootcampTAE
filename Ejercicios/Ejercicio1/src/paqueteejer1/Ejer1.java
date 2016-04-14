package paqueteejer1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Ejer1 {

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
@Test(
description = "Ejercicio1"
)
public void ejercicio1() {
	
	driver.get("http://www.labrujula24.com");
	WebElement elemento =driver.findElement(By.className("news-title-box"));
	elemento.click();
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fb_ltr']")));
	WebElement TextElement =driver.findElement(By.xpath("//span[@class=' _50f7']"));
	char num_com = TextElement.getText().charAt(0);
	if ((int)num_com > 0) {
		String Comprobador = "noticia";
		WebElement Comentario =driver.findElement(By.xpath("//span[@class='_5mdd']"));
		String Texto = Comentario.getText();
		System.out.println(Texto);
		
	
	driver.switchTo().defaultContent();

	Assert.assertTrue(Texto.toLowerCase().contains(Comprobador), "si se encuentra la palabra noticia en el comentario");
	}
	
	


	


}
}
