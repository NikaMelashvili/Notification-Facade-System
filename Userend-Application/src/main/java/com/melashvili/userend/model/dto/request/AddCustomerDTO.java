package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCustomerDTO {
    private String firstName;
    private String lastName;
    private Integer phone;
    private String email;
    private String password;
}
