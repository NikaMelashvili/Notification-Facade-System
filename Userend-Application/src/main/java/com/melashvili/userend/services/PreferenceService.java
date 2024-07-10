package com.melashvili.userend.services;

import com.melashvili.userend.model.dto.request.UpdatePreferencesDTO;
import com.melashvili.userend.model.dto.response.PreferenceResponseDTO;
import com.melashvili.userend.model.dto.response.UserPreferencesDTO;
import com.melashvili.userend.model.dto.response.UserResponseDTO;
import com.melashvili.userend.model.entitites.Preferences;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.repositories.PreferencesRepository;
import com.melashvili.userend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreferenceService {

    private UserRepository userRepository;

    private PreferencesRepository preferencesRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPreferencesRepository(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    public List<UserPreferencesDTO> getAllUserPreferences() {
        List<UserPreferencesDTO> usersPreferences = new ArrayList<>();
        List<Preferences> preferencesList = preferencesRepository.findAll();
        List<User> userPreferencesDTOS = (List<User>) userRepository.findAll();
        for (Preferences preferences : preferencesList) {
            for (User user : userPreferencesDTOS) {
                UserPreferencesDTO userPreferencesDTO = new UserPreferencesDTO();
                UserResponseDTO userResponseDTO = new UserResponseDTO();
                PreferenceResponseDTO preferenceResponseDTO = new PreferenceResponseDTO();

                userResponseDTO.setId(user.getId());
                userResponseDTO.setFirstName(user.getFirstName());
                userResponseDTO.setLastName(user.getLastName());
                userResponseDTO.setEmail(user.getEmail());

                preferenceResponseDTO.setEmailOpt(preferences.getEmailOpt());
                preferenceResponseDTO.setMobileOpt(preferences.getMobileOpt());
                preferenceResponseDTO.setPromoOpt(preferences.getPromoOpt());

                userPreferencesDTO.setPreferences(preferenceResponseDTO);
                userPreferencesDTO.setUser(userResponseDTO);

                usersPreferences.add(userPreferencesDTO);
            }
        }
        return usersPreferences;
    }

    public void updatePreferences(Long id, UpdatePreferencesDTO updatePreferencesDTO) {
        Preferences preferences = preferencesRepository.findById(id).orElse(null);

        assert preferences != null;
        preferences.setEmailOpt(updatePreferencesDTO.getOptEmail());
        preferences.setMobileOpt(updatePreferencesDTO.getOptSms());
        preferences.setPromoOpt(updatePreferencesDTO.getOptPromo());

        preferencesRepository.save(preferences);
    }
}
