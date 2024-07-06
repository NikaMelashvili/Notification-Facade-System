package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCustomerDTO {
    private UserRegisterDTO user;
    private AddressRegisterDTO address;
    private PreferencesRegisterDTO preferences;
}
