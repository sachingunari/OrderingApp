package com.ordering.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// ...

public class MailClient {

	 public void sendMail(String receiver,String sender,String usernameurl, String Token) {
	      // Recipient's email ID needs to be mentioned.
	      String to = receiver;//change 

	      // Sender's email ID needs to be mentioned
	      String from = sender;//change accordingly
	      final String username = "parveenkumar275";//change accordingly
	      final String password = "project275";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "relay.jangosmtp.net";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Testing Subject");

	         // Now set the actual message
	         message.setText("http://localhost:8080/CRUDWebAppMavenized/enable/"+usernameurl+"/"+Token);

	         // Send message
	         Transport.send(message);

	       //  System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }
	 }