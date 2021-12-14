package newpackage;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.mail.Transport;


public class emailwithattachment 
{

	public static void main(String[] args) throws Exception  
	{
		 
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
		 }  
	}

