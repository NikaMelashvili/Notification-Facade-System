package com.melashvili.userend.controller;

import com.melashvili.userend.services.EmailService;
import com.melashvili.userend.services.MessageStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/notifications")
public class MessageLogController {

    private EmailService emailService;

    private MessageStatsService messageStatsService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setMessageStatsService(MessageStatsService messageStatsService) {
        this.messageStatsService = messageStatsService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body
    ) {
        boolean success = emailService.sendEmail(to, subject, body);
        if (success) {
            return ResponseEntity.ok("Email sent successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to send email.");
        }
    }

    @GetMapping("/success-rate")
    public ResponseEntity<Double> getSuccessRate(){
        Double rate = messageStatsService.calculateSuccessRate();
        return ResponseEntity.ok(rate);
    }

    @GetMapping("/undelivered-percentage")
    public ResponseEntity<Double> getUndeliveredMessagePercentage() {
        double percentage = messageStatsService.getUndeliveredMessagePercentage();
        return ResponseEntity.ok(percentage);
    }

    @GetMapping("/undelivered-recipients")
    public ResponseEntity<List<String>> getUndeliveredMessageRecipients() {
        List<String> recipients = messageStatsService.getUndeliveredMessageRecipients();
        return ResponseEntity.ok(recipients);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> countTotalMessages(){
        Long total = messageStatsService.countTotalMessages();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }

    @GetMapping("/undelivered")
    public ResponseEntity<Long> countUndeliveredMessages(){
        Long total = messageStatsService.countUndeliveredMessages();
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
