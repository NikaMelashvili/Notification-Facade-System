package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPreferencesDTO {
    private UserResponseDTO user;
    private PreferenceResponseDTO preferences;
}
