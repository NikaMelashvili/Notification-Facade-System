package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePreferencesDTO {
    private Boolean optEmail;
    private Boolean optSms;
    private Boolean optPromo;
}
