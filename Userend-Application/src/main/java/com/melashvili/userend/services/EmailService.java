package com.melashvili.userend.services;

import com.melashvili.userend.model.entitites.MessageLog;
import com.melashvili.userend.repositories.MessageLogRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class EmailService {

    private SendGrid sendGrid;

    private MessageLogRepository messageLogRepository;

    @Autowired
    public void setSendGrid(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    @Autowired
    public void setMessageLogRepository(MessageLogRepository messageLogRepository) {
        this.messageLogRepository = messageLogRepository;
    }

    public Boolean sendEmail(String to, String subject, String body) {
        Email from = new Email("somemail@melashvili.com");
        Email recipient = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, recipient, content);

        Request request = new Request();
        boolean success = false;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            success = response.getStatusCode() == 202;
        } catch (IOException ex) {
            throw new RuntimeException(ex + ". Mail wasn't sent");
        } finally {
            logMessage(to, subject, body, success);
        }

        return success;
    }

    private void logMessage(String to, String subject, String body, Boolean success) {
        MessageLog log = new MessageLog();
        log.setRecipient(to);
        log.setSubject(subject);
        log.setBody(body);
        log.setSuccess(success);
        log.setTimestamp(LocalDateTime.now());
        messageLogRepository.save(log);
    }
}
