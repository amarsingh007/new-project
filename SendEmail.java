package com.sdj;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail  {
	
		public static void sendEmail(String to)
		{
			final String username="";
			final String password="";
			Properties pros=new Properties();
			pros.put("mail.smtp.auth", "true");
			pros.put("mail.smtp.starttls.enable", "true");
			pros.put("mail.smtp.host", "smtp.gmail.com");
			pros.put("mail.smtp.port", "25");
			Session session=Session.getDefaultInstance(pros,new javax.mail.Authenticator(){
				 protected PasswordAuthentication  getPasswordAuthentication()
				{
					return  new PasswordAuthentication(username,password);
				}
			});
			try
			{
				Message message= new  MimeMessage(session);
				message.setFrom(new InternetAddress("amarsingh151996@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject("A testing mail header !!!");
				message.setText("Dear Mail Crawler,"+"\n\n No spam to my email,please!");
				Transport.send(message);
				System.out.println("Done");
				}
				catch(MessagingException e)
			   {
				System.out.println("Username and Password are incorrect.....exiting!");	
			
			}}
		public static void main(String [] args)
		{
			String to="raoamar1996@gmail.com";
			sendEmail(to);
		}
		
		
	}


/*
String to="raoamar1996@gmail.com";
String from="amarsingh151996@gmail.com";
String host="1276*.0.0.1";//or ip address


//Get the session code
Properties properties=System.getProperties();
properties.setProperty("mail.smtp.host", host);
Session session=Session.getDefaultInstance(properties);



//Compose the mesage
try
{
MimeMessage message=new MimeMessage(session);
message.setFrom(new InternetAddress(from));
message.addRecipient(Message.RecipientType.TO,  new InternetAddress(to));
message.setSubject("xxx");
message.setText("Hii");


//send message
Transport.send(message);
System.out.println("message sent successfully");

}
catch(MessagingException mex)
{
mex.printStackTrace();
}*/