package proyectofinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import proyectofinal.Logeo1;
import proyectofinal.Logeo2;


public class Clase1 {
	static  WebDriver driver = new FirefoxDriver();
	
	private Logeo1 Log1;
	private Logeo2 Log2;
	@BeforeMethod
		public void Logs(){
		Log1 = new Logeo1();
		Log2 = new Logeo2();
		driver.manage().window().maximize();
	}
	
	
	

	@DataProvider(name = "Logeonro1")
	   public static Object[][] Logeo1() {
	      return new Object[][] {{"rubencamara1234@gmail.com", "Ruben1234"}};
	      
	}
	
	
	@Test(priority = 1 ,dataProvider ="Logeonro1")
	public void Log1(String user,String pass) {
		Log1.Logear(user, pass);
		}
	@DataProvider(name = "EnviarMails")
	   public static Object[][] Mails() {
	      return new Object[][] {{"rubencamara4321@gmail.com", "Asunto1","Mensaje1"},{"rubencamara4321@gmail.com","Asunto2","Mensaje2"},{"rubencamara4321@gmail.com","Asunto3","Mensaje3"}};
	}   
	      
	@Test(dependsOnMethods={"Log1"},priority = 2 , dataProvider = "EnviarMails")
	 public void EnviarMails(String Destinatario, String Asunto, String Mensaje){
		Log1.MandarMails(Destinatario, Asunto, Mensaje);
	}
	
	@DataProvider(name = "ComprobarMails")
	   public static Object[][] Mails2() {
	      return new Object[][] {{"rubencamara4321@gmail.com", "Mensaje1","Mensaje2","Mensaje3"}};
	}
	@Test(dependsOnMethods={"EnviarMails"},priority =3, dataProvider = "ComprobarMails")
	public void ComprobarMails(String Destinatario, String Mensaje1 ,String Mensaje2, String Mensaje3){
		
			 
		 Assert.assertTrue(Log1.VerificarEnv(Destinatario, Mensaje1, Mensaje2, Mensaje3), "No se paso la comprobacion de emails enviados");
		 }
		 
	
	
	
	
	@Test (priority = 4,dependsOnMethods= {"ComprobarMails"})
	public void Deslog(){
		Log1.Deslogear();
		}

	@DataProvider(name = "Logeonro2")
	   public static Object[][] Logeos() {
	      return new Object[][] {{"rubencamara4321@gmail.com", "Ruben1234"}};
	      
	}
	
@	Test(dependsOnMethods={"Deslog"},priority = 5, dataProvider = "Logeonro2")
	public void Log2(String user, String pass){
		Log2.Logear(user, pass);
	
			}

	@DataProvider(name = "MailsRecibidos")
	public static Object[][] MailsRec() {
		return new Object[][] {{"rubencamara1234@gmail.com", "Mensaje1","Mensaje2","Mensaje3"}};
			}
	
	@Test(dependsOnMethods={"Log2"},priority = 6, dataProvider = "MailsRecibidos")
	public void Verificar(String Remitente, String Mensaje1,String Mensaje2, String Mensaje3){
		Assert.assertTrue(Log2.VerificarRec(Remitente, Mensaje1, Mensaje2, Mensaje3), "No se paso la comprobacion de recibidos");
		driver.close();
		}


	

}

			
			
	


		
		 
		 
		
		


