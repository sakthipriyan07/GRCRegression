package Keymethods;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendMailSSLWithAttachment{
public static void main(String[] args) {
	

// public void main() throws EmailException{
	 Properties props = new Properties();

		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp-relay.sendinblue.com");
		//props.put("mail.smtp.host", "smtp.gmail.com");
		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "587");

		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "587");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication("legalisnowsimple@gmail.com","xsmtpsib-c983edc8e24c956b9076ebec147580bcb684402b24892673c885fdcf56296b15-mrcp0QBZG9FTxSfR");

					}

				});

		try { 

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("automation@vakilsearch-emailer.com"));

			// Set the recipient address
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sakthi.priyan@vakilsearch.com"));
         			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sakthi.priyan@vakilsearch.com,sakthipriyan071297@gmail.com,kavitha.jagatheeswaran@vakilsearch.com,saravanan.muthu@vakilsearch.com,selvamani@vakilsearch.com,aejaaz.ghouse@vakilsearch.com,naveen.nagalingam@vakilsearch.com,divya.vijayaraghavan@vakilsearch.com"));

                     // Add the subject link
			message.setSubject("CriticalFlow Automation");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Automation Test Result");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = "C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\extentreport.html";

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}