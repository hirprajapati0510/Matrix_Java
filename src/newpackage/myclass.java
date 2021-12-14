	package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
//***********Email*****************
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.mail.Transport;


public class myclass {

	public static void main(String[] args) throws InterruptedException,FileNotFoundException, IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://matrix-stage.liveu.tv");
		driver.manage().window().maximize();	
		Thread.sleep(4000);
		
		 
	    WebElement username = driver.findElement(By.xpath("//*[@id=\'txtUsername\']"));
	    username.sendKeys("Curator01");
	  //username.sendKeys("Affiliate01");
	  //username.sendKeys("MGcurator01");
	    Thread.sleep(2000);
	    
	    WebElement pwd = driver.findElement(By.xpath("//*[@id=\'txtPassword\']"));
	    pwd.sendKeys("LiveU123!");	    
	    Thread.sleep(3000);
	    
	    WebElement Login = driver.findElement(By.xpath("//*[@id=\'btnLogin\']"));
	    Login.click();
	    
	    Thread.sleep(55000);
	    
	    WebElement setting;
	    setting = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]"));
	    setting.click();              
	    Thread.sleep(1000);

	    
	    WebElement whatsnew;
	    whatsnew = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]/ul/li[9]"));
	    whatsnew.click();
	    Thread.sleep(1000);

	    WebElement whatsnewcancel;
	    whatsnewcancel = driver.findElement(By.xpath("//*[@id=\'openWhatsNew\']/div/div/div[1]/a"));
	    whatsnewcancel.click();
	    Thread.sleep(1000);                    
	                                       
	    WebElement chat;
	    chat = driver.findElement(By.className("chat_svg"));
	    chat.click();
	    Thread.sleep(10000);

	    WebElement chatbox;
	    chatbox = driver.findElement(By.id("textchat"));
	    chatbox.sendKeys("chat test");
	    Thread.sleep(8000);

	    WebElement chatsend;
	    chatsend = driver.findElement(By.className("svg_send"));
	    chatsend.click();
	    Thread.sleep(8000);
	    chat.click();
	    Thread.sleep(2000);

	    // WebElement icon = driver.findElement(By.className("ng-scope"));
        // icon.click();

	    setting.click();
	    Thread.sleep(2000);

	    WebElement logout;
	    logout = driver.findElement(By.xpath("//*[@id=\'wrapper\']/header/div[1]/div[2]/div/div[3]/div[2]/div[3]/ul/li[10]/a"));
	    logout.click();  
	    
//	    WebElement drag1 = driver.findElement(By.xpath("//span[test()='topTitle text-truncate ng-binding']"));
	    //*[@id=\'Affiliate_Local_Feeds_Sction\']/ul/li[1]
	    //*[@id="Affiliate_Local_Feeds_Sction"]/ul/li[1]/div/div[2]/div[1]
//	    WebElement drop1 = driver.findElement(By.xpath("//*[@id=\'three\']/div/div[2]/ul/li[2] ")); 
//	    Thread.sleep(15000);	 
//	    Actions act = new Actions(driver);
//	    Thread.sleep(15000);
//	    act.clickAndHold(drag1).build().perform();
//	    System.out.print("clickandhold  ");
//	    act.moveToElement(drop1).build().perform();
//	    System.out.print("Moveanddrop  ");	    
//	    act.release(drop1).build().perform(); 
//	    System.out.print("release  ");
//	    Thread.sleep(15000);
	    
//       //Element which needs to drag.    
//	     WebElement From=driver.findElement(By.xpath("//*[@id=\'Affiliate_Local_Feeds_Sction\']/ul/li[1]/div"));
//	     Thread.sleep(6000);
//	     //Element on which need to drop.
//	     WebElement To=driver.findElement(By.xpath("//*[@id=\'three\']/div/div[2]/ul/li[2]/div"));
//	     Thread.sleep(6000);
//	     //Using Action class for drag and drop.
//	     Actions act=new Actions(driver);
//	     Thread.sleep(7000);
//	     //Dragged and dropped.
//	     act.dragAndDrop(From, To).build().perform();
	    
	    
	    
	    //************************* Email With Attachment*******************************************
	    //******************************************************************************************
	      final String user="hiren@intellimedianetworks.net"; 
		  final String password="Hiren@123";
		  String from="hiren@intellimedianetworks.net";
		  String to="akshay@intellimedianetworks.net";
		   
		     
		  Properties properties = new Properties(); 
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.host", "smtppro.zoho.com");  
		  properties.put("mail.smtp.port","587");
		  
		  Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() 
		  {  
		   protected PasswordAuthentication getPasswordAuthentication() 
		   {  
		   return new PasswordAuthentication(user,password);  
		   }  
		  });  
		     
		  
		  //2) compose message     
		  MimeMessage message = new MimeMessage(session);  
		  
		  try
		  {  
			    message.setFrom(new InternetAddress(from));  
			    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			    message.setSubject("Message Aleart");  	
			    
			    MimeBodyPart textBodyPart = new MimeBodyPart();
			    textBodyPart.setText("Dear Sir Please Find attachment of Testing Result of Cross Browser Testing in html form");
			    
			    MimeBodyPart htmlattachment = new MimeBodyPart();
			    htmlattachment.attachFile("C:\\Users\\IM0258\\eclipse-workspace\\newproject\\test-output\\emailable-report.html");
	
			    Multipart emailContent = new MimeMultipart();
		        emailContent.addBodyPart(textBodyPart);
		        emailContent.addBodyPart(htmlattachment);
		      
		        message.setContent(emailContent);
		            
		       Transport.send(message);
		       
		       System.out.println("message sent....");  
		   }
		  catch (MessagingException ex) 
		  {
			   ex.printStackTrace();
		  }  
	    
	    	    
		driver.close();
	}
}
