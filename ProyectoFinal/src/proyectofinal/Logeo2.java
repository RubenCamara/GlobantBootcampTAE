package proyectofinal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logeo2 {
	public void Logear(final String user,String pass){
		Clase1.driver.findElement(By.xpath("//a[@id='account-chooser-link']")).click();;
		
		
		Clase1.driver.findElement(By.xpath("//a[@id='account-chooser-add-account']")).click();;
		
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
	
	public boolean VerificarRec(final String Remitente, String Mensaje1,String Mensaje2, String Mensaje3){
		
		Boolean Correo1 = false;
		Boolean Correo2 = false;
		Boolean Correo3 = false;
		String Msj1;
		String Msj2;
		String Msj3;
		String Remit;
		String NroCorreos;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Clase1.driver.findElement(By.id("gbqfq")).sendKeys("in:inbox "+Remitente); //entro a los enviados filtrados por remitente
		Clase1.driver.findElement(By.id("gbqfb")).click();
		try {Thread.sleep(1300);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
		
		WebElement Tabla = Clase1.driver.findElement(By.xpath("//div[@class='ae4 UI UJ']"));
		List<WebElement> Filas = Tabla.findElements(By.tagName("tr"));
		//verificacion de primer mensaje
		for(WebElement Fila:Filas){
			Fila.click();
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(")) && (NroCorreos.contains(")"))){//verifico si contiene mas de un mensaje esa conversacion
				//mas de una linea de mensajes en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));														
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj1 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				Remit = UltimoCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();	
				//esto es por si tiene mas de un mensaje igual al ultimo, el mensaje no esta visible, con el click lo hago visible
			}
			else{
				//solo una linea  en la conversacion
				WebElement UltimoCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj1 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				Remit = UltimoCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();				
			}			
						
			if ((Remit.contains(Remitente)) && (Mensaje1.equals(Msj1))){
				Correo1 = true;
			}								
			
			Clase1.driver.navigate().back();
			
			try {Thread.sleep(1300);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}

		
		try {Thread.sleep(1300);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
		//verificacion de segundo mensaje
		for(WebElement Fila:Filas){
			Fila.click();
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(")) && (NroCorreos.contains(")"))){
				//mas de una linea en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));														
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj2 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				Remit = UltimoCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();	
				//esto es por si tiene mas de un mensaje igual al ultimo, el mensaje no esta visible
			}
			else{
				//solo una linea en la conversacion
				WebElement UltimoCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj2 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				Remit = UltimoCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();				
			}			
						
			if ((Remit.contains(Remitente)) && (Mensaje2.equals(Msj2))){
				Correo2 = true;
			}								
			
			Clase1.driver.navigate().back();
			
			try {Thread.sleep(1300);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
		
		
		try {Thread.sleep(1300);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
		//verificacion de tercer mensaje
		for(WebElement Fila:Filas){
			Fila.click();
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			NroCorreos = Celdas.get(3).getText();
			if((NroCorreos.contains("(") && (NroCorreos.contains(")")))){
				//mas de una linea en la conversacion
				WebElement Lista = Clase1.driver.findElement(By.xpath("//div[@class='nH aHU']"));							
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));													
				WebElement UltimoCorreo = Correos.get(Correos.size()-1);														
				UltimoCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												
				Msj3 = UltimoCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							
				Remit = UltimoCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();	
				//esto es por si tiene mas de un mensaje igual al ultimo, el mensaje no esta visible
			}
			else{
				//solo una linea en la conversacion
				WebElement ultCorreo = Clase1.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			
				Msj3 = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								
				Remit = ultCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();				
			}			
						
			if ((Remit.contains(Remitente)) && (Mensaje3.equals(Msj3))){
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

		
		


