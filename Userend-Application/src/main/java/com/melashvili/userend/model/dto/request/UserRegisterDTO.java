package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
}
