package newpackage;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Testemail
{

	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Start Sending");
		
		Email email = new SimpleEmail();
		email.setHostName("smtppro.zoho.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("hiren@intellimedianetworks.net", "Hiren@123"));
		email.setSSLOnConnect(true);
		email.setFrom("hiren@intellimedianetworks.net");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail for testing automation... :-)");
		email.addTo("akshay@intellimedianetworks.net");
	    email.send();
		System.out.println("Done Sending");

	}

}
