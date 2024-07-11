package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreferencesRegisterDTO {
    private Boolean emailOpt;
    private Boolean smsOpt;
    private Boolean promoOpt;
}
