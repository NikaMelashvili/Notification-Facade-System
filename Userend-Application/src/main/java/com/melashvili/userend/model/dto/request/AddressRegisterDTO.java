package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRegisterDTO {
    private String street;
    private Integer number;
    private Integer postalCode;
}
