package dao;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
public class SendEmail {

	public void sendMail(String to,String username,String password) {
		 // Recipient's email ID needs to be mentioned.
       // String to = "mohamed.hafidi.mh@gmail.com";

        // Sender's email ID needs to be mentioned
        String from ="meknesbachelor99@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("meknesbachelor99@gmail.com", "bachmek99");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("De l'�quipe d'administration du Bachmek!");

            // Now set the actual message
            message.setText("Bonjour,"
            		+ "Vous avez d�sormaiment un compte sur notre plateforme avec les coordonn�es suivantes"
            		+ "Username :"+username+""
            				+ "password : "+password);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
