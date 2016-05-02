package proyectofinal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
public class Logeo1 {
	
	
	public void Logear(final String user,String pass){
		Clase1.driver.get("http://www.gmail.com");		
		Clase1.driver.findElement(By.id("Email")).sendKeys(user);
		Clase1.driver.findElement(By.id("next")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clase1.driver.findElement(By.id("Passwd")).sendKeys(pass);;
		Clase1.driver.findElement(By.id("signIn")).click();
		
		
		}
	
	public void MandarMails(final String Destinatario, String Asunto, String Mensaje){
		WebElement myDynamicElement = (new WebDriverWait(Clase1.driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//div[@class = 'z0']//div[@role = 'button']")));
		Clase1.driver.findElement(By.xpath( "//div[@class = 'z0']//div[@role = 'button']")).click();
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clase1.driver.findElement(By.className("vO")).sendKeys(Destinatario);
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clase1.driver.findElement(By.className("aoT")).sendKeys(Asunto);
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clase1.driver.findElement(By.xpath("//div[@class='Ar Au']//div[@role='textbox']")).sendKeys(Mensaje);;
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clase1.driver.findElement(By.xpath("//div[@class ='J-J5-Ji']//div[@role='button']")).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public boolean VerificarEnv(final String Destinatario, String Mensaje1 ,String Mensaje2, String Mensaje3){
		
		Clase1.driver.findElement(By.className("gbqfif")).sendKeys("in:sent");
		Clase1.driver.findElement(By.className("gbqfb")).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Boolean Correo1 = false;
		Boolean Correo2 = false;
		Boolean Correo3 = false;
		String Msj1;
		String Msj2;
		String Msj3;
		String Dest;
		String NroCorreos;
		
		WebElement Tabla = Clase1.driver.findElement(By.xpath("//div[@class='ae4 UI']"));
		
		List<WebElement> Filas = Tabla.findElements(By.tagName("tr"));
//-------------------------------------------------------------------------------------------------------------		
		for(WebElement Fila:Filas){	
			//verifico primer mensaje enviado
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(")) && (NroCorreos.contains(")"))){//verifico si contiene mas de un mensaje esa conversacion
				//mas de una linea enviada en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));														
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj1 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				UltimoCorreo.findElement(By.className("ajy")).click();															
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();	
			}
			else{
				//solo una linea enviada en la conversacion
				WebElement UltimoCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj1 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				UltimoCorreo.findElement(By.className("ajy")).click();																
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  
			}
				
			if((Dest.contains(Destinatario)) && (Mensaje1.equals(Msj1))){
				Correo1 = true;
			}			
			
			Clase1.driver.navigate().back();
			
			try {Thread.sleep(3000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}			
		}				
//-------------------------------------------------------------------------------------------------------------		
		for(WebElement Fila:Filas){	
			//verifico segundo mensaje enviado
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(")) && (NroCorreos.contains(")"))){// verifico si contiene mas de un mensaje esa conversacion
				//mas de una linea enviada en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));														
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj2 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				UltimoCorreo.findElement(By.className("ajy")).click();															
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();
				//esto es por si tiene mas de un mensaje igual al ultimo, el mensaje no esta visible
			}
			else{
				//solo una linea enviada en la conversacion
				WebElement UltimoCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj2 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				UltimoCorreo.findElement(By.className("ajy")).click();																
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  
			}
				
			if((Dest.contains(Destinatario)) && (Mensaje2.equals(Msj2))){
				Correo2 = true;
			}			
			
			Clase1.driver.navigate().back();
			
			try {Thread.sleep(1300);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}			
		}
//-------------------------------------------------------------------------------------------------------------		
		for(WebElement Fila:Filas){
			//verifico tercer mensaje enviado
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(")) && (NroCorreos.contains(")"))){
				//mas de una linea enviada en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));														
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj3 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				UltimoCorreo.findElement(By.className("ajy")).click();															
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();	
				//esto es por si tiene mas de un mensaje igual al ultimo, el mensaje no esta visible
			}
			else{
				//solo un correo enviado en la conversacion
				WebElement UltimoCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj3 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				UltimoCorreo.findElement(By.className("ajy")).click();																
				Dest = UltimoCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  
			}
				
			if((Dest.contains(Destinatario)) && (Mensaje3.equals(Msj3))){
				Correo3 = true;
			}			
			
			Clase1.driver.navigate().back();
			
			try {Thread.sleep(1300);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}			
		}

		if(Correo1 == true && Correo2 == true && Correo3 == true){
			return true; 
		}
		else{
			return false;
		}				
	}

	public void Deslogear(){
		Clase1.driver.findElement(By.xpath("//a[@class='gb_b gb_7a gb_R']")).click();
		Clase1.driver.findElement(By.id("gb_71")).click();
				
	}
	
}


