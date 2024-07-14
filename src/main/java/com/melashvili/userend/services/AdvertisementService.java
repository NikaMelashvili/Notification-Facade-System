package com.melashvili.userend.services;

import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.Preferences;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.repositories.AddressRepository;
import com.melashvili.userend.repositories.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementService {

    private PreferencesRepository preferencesRepository;
    private AddressRepository addressRepository;
    private EmailService emailService;
    private SmsService smsService;

    @Autowired
    public void setPreferencesRepository(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }

    public List<String> getEmails() {
        List<String> emails = new ArrayList<>();
        List<Preferences> preferences = preferencesRepository.findAll();
        List<Address> addresses = addressRepository.findAll();

        for (Preferences preference : preferences) {
            if (preference.getEmailOpt()) {
                for (Address address : addresses) {
                    if (address.getUser().equals(preference.getCustomerId())) {
                        emails.add(address.getEmail());
                        break;
                    }
                }
            }
        }
        return emails;
    }

    public List<String> getSmsNumbers() {
        List<String> smsNumbers = new ArrayList<>();
        List<Preferences> preferences = preferencesRepository.findAll();
        List<Address> addresses = addressRepository.findAll();

        for (Preferences preference : preferences) {
            if (preference.getSmsOpt()) {
                for (Address address : addresses) {
                    if (address.getUser().equals(preference.getCustomerId())) {
                        smsNumbers.add(String.valueOf(address.getNumber()));
                        break;
                    }
                }
            }
        }
        return smsNumbers;
    }

    public void sendAllContent(List<User> users) {
        List<String> emails = getEmails();
        List<String> smsNumbers = getSmsNumbers();

        String messageBody = "Some content for message body";
        String subject = "Message subject here";

        for (User user : users) {
            Address address = addressRepository.findByUser(user);
            if (address == null) {
                continue;
            }

            String email = address.getEmail();
            String phoneNumber = String.valueOf(address.getNumber());

            if (emails.contains(email)) {
                emailService.sendEmail(email, subject, messageBody);
            }

            if (smsNumbers.contains(phoneNumber)) {
                smsService.sendSms(phoneNumber, messageBody);
            }
        }
    }
}

