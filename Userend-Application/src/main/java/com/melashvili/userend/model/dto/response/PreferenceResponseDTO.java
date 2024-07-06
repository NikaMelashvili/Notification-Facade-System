package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreferenceResponseDTO {
    private Long id;
    private String notificationType;
    private Boolean option;
}
