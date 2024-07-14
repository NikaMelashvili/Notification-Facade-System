package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressInfo {
    private String email;
    private String street;
    private Integer phone;
    private Integer postal;
}
