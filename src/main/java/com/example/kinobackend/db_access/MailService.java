package com.example.kinobackend.db_access;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    public void sendEmail(String to,String subject, Multipart multipart){
        String from = "kinobuchung@gmail.com";
        String password = "zqwhrsqhtcnunefq";
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port","465 ");
        properties.put("mail.smtp.auth","true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        };
        System.out.println(properties);
        Session session = Session.getDefaultInstance(properties,auth);
        System.out.println(session.getProperties());
        System.out.println("trying to send Message");
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            message.setSubject(subject);
            message.setContent(multipart);
            System.out.println(message);
            Transport.send(message);
            System.out.println("message sent");
        }catch (MessagingException mex){
            mex.printStackTrace();
        }
    }

}
