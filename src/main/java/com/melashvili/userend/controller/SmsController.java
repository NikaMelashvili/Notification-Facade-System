package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.SmsRequestDTO;
import com.melashvili.userend.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/sms")
public class SmsController {

    private SmsService smsService;

    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendSms(@RequestBody SmsRequestDTO smsRequest) {
        smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

