package com.psa.location_web_app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	JavaMailSender mailSender;

		public void sendEmail(String toAddress, String emailSubject, String emailBody) {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message);
			
			try {
			messageHelper.setTo(toAddress);
			messageHelper.setText(emailSubject);
			messageHelper.setSubject(emailBody);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
