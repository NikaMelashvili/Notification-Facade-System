package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.UpdatePreferencesDTO;
import com.melashvili.userend.model.dto.response.UserPreferencesDTO;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.services.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/preferences")
public class PreferenceController {

    private PreferenceService preferenceService;

    @Autowired
    public void setPreferenceService(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping("/get/user-pre")
    public ResponseEntity<List<UserPreferencesDTO>> getPreferencesList() {
        List<UserPreferencesDTO> userPreferencesList = preferenceService.getAllUserPreferences();
        return new ResponseEntity<>(userPreferencesList, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updatePreferences(@RequestParam Long id,
                                                  @RequestBody UpdatePreferencesDTO updatePreferencesDTO){
        preferenceService.updatePreferences(id, updatePreferencesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/by-email-opt")
    public ResponseEntity<List<User>> getUsersByEmailOpt(@RequestParam Boolean emailOpt) {
        return ResponseEntity.ok(preferenceService.getUsersByEmailOpt(emailOpt));
    }

    @GetMapping("/users/by-sms-opt")
    public ResponseEntity<List<User>> getUsersBySmsOpt(@RequestParam Boolean smsOpt) {
        return ResponseEntity.ok(preferenceService.getUsersBySmsOpt(smsOpt));
    }

    @GetMapping("/users/by-promo-opt")
    public ResponseEntity<List<User>> getUsersByPromoOpt(@RequestParam Boolean promoOpt) {
        return ResponseEntity.ok(preferenceService.getUsersByPromoOpt(promoOpt));
    }
}
