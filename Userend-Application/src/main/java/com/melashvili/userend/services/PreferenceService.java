package com.melashvili.userend.services;

import com.melashvili.userend.model.dto.request.PreferencesRegisterDTO;
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
        List<Preferences> preferencesList = (List<Preferences>) preferencesRepository.findAll();
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
                userResponseDTO.setPostal(user.getPostal());
                userResponseDTO.setRole(user.getRole());

                preferenceResponseDTO.setId(preferences.getPreferenceId());
                preferenceResponseDTO.setNotificationType(preferenceResponseDTO.getNotificationType());
                preferenceResponseDTO.setOption(preferences.getOption());

                userPreferencesDTO.setUser(userResponseDTO);
                userPreferencesDTO.setPreferences(preferenceResponseDTO);

                usersPreferences.add(userPreferencesDTO);
            }
        }
        return usersPreferences;
    }

    public void addPreference(Long userId, PreferencesRegisterDTO preferencesRegisterDTO) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Preferences preferences = new Preferences();

        preferences.setNotificationType(preferencesRegisterDTO.getNotificationType());
        preferences.setOption(preferencesRegisterDTO.getStatus());
        preferences.setCustomerId(user);

        preferencesRepository.save(preferences);

        UserPreferences userPreferences = new UserPreferences();

        userPreferences.setUserId(user);
        userPreferences.setPreferenceId(preferences);

//        userPreferencesRepository.save(userPreferences);
        System.out.print("Preferences saved");
    }
}
