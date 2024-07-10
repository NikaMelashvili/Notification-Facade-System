package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.UpdatePreferencesDTO;
import com.melashvili.userend.model.dto.response.UserPreferencesDTO;
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

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updatePreferences(@PathVariable Long id,
                                                  @RequestBody UpdatePreferencesDTO updatePreferencesDTO){
        preferenceService.updatePreferences(id, updatePreferencesDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
