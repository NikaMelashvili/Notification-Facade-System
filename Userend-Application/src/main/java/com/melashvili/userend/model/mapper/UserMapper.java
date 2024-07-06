package com.melashvili.userend.model.mapper;

import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.response.UserResponseDTO;
import com.melashvili.userend.model.entitites.User;

public class UserMapper {
    public static UserResponseDTO toUserResponse(User user) {
        UserResponseDTO userResponse = new UserResponseDTO();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setPostal(user.getPostal());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());

        return userResponse;
    }

    public static User toUser(AddCustomerDTO userResponse) {
        User user = new User();

        user.setFirstName(userResponse.getUser().getFirstName());
        user.setLastName(userResponse.getUser().getLastName());
        user.setPostal(userResponse.getUser().getPostal());
        user.setEmail(userResponse.getUser().getEmail());
        user.setPassword(userResponse.getUser().getPassword());

        return user;
    }
}
