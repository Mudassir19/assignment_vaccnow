package com.xebia.assignment_vacc.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class MailSender {

    private static final String CLASS_NAME = MailSender.class.getName();

    private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

    public static String sendEmail(String toAddress) {

        LOGGER.info("inside send sendEmail () of: " + CLASS_NAME);
        String userName = "mudassir.shaikh@xebia.com";
        String password = "HB64I+FRiiSXOulV8TLjqw==";
        String host = "smtp.office365.com";
        String port = "587";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.debug.auth", "true");
        properties.put("mail.smtp.socketFactory.fallback", "true");

        String decryptedPassword =
                AES_Password_Encryption.decrypt(password, "assignment_paswd");
        Session session =
                Session.getInstance(
                        properties,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(userName, decryptedPassword);
                            }
                        });

        String status;
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName));
            String toAdd = toAddress;
            String[] recipientList = toAdd.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            msg.setRecipients(Message.RecipientType.TO, recipientAddress);
            msg.setSubject("payment confirmation");

            msg.setSentDate(new Date());
            // set plain text message
            msg.setText("Your order has been placed successfully:");

            Transport.send(msg);
            status = "Mail Sent";
            LOGGER.info("Email Sent Successfully:");
        } catch (Exception e) {
            status = "Mail Not Sent";
            e.printStackTrace();
            LOGGER.info("Error was occurred during sending: the mail");
        }

        return status;
    }
}