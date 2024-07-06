package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private Integer postalCode;
    private String street;
}
