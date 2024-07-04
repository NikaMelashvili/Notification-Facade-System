package com.melashvili.userend.model.dto.response;

import com.melashvili.userend.model.base.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
