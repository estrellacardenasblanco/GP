package cu.edu.cujae.pweb.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void send(String email, String ip, String image) {
			
        String to = email; 
        String from = "supportsias@accounts.ias.com";
        String host = "smtp.gmail.com";
    
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("proyect.ias@gmail.com", "proyectoias.eea");
                
            }

        });
       
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(from);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Warning. We have found suspicious activity");

            message.setText("An attempt was made to access your IAS account from IP "+ ip 
            		+ ".\n The image used was "+ image +". If it was not you, contact us at our company."
            		+ " We have 24 hour support.");

            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
		
	}
	
	
}
