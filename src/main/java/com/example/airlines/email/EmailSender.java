package com.example.airlines.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@airlines.com", "AirLines");
        helper.setTo(email);

        String subject = "Here's the link to reset your password";
        String content = "<p>Hello,</p>" + "You have requested to reset your password."
                + "Click the link below to change your password " +
                "<b><a href= \"" + resetPasswordLink + "\">Change my password</a></b>" + " " +
                "Ignore this email if you don't remember your password, or you have not made the request";

        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }
}
