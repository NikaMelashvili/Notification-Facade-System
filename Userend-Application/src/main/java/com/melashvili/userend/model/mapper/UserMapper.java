package com.melashvili.userend.model.mapper;

import com.melashvili.userend.model.dto.response.UserResponse;
import com.melashvili.userend.model.entitites.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());

        return userResponse;
    }
}
