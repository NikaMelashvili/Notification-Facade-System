package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreferenceResponseDTO {
    private Long id;
    private Boolean emailOpt;
    private Boolean mobileOpt;
    private Boolean promoOpt;
}
