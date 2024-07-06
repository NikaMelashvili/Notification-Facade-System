package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreferencesRegisterDTO {
    private Boolean email;
    private Boolean sms;
    private Boolean promo;
}
