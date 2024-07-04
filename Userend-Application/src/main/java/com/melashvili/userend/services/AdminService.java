package com.melashvili.userend.services;

import com.melashvili.userend.model.base.Role;
import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.response.UserResponse;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.model.mapper.UserMapper;
import com.melashvili.userend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addOrUpdateCustomer(AddCustomerDTO customerDTO) {
        User user = new User();

        user.setFirstName(customerDTO.getFirstName());
        user.setLastName(customerDTO.getLastName());
        user.setPhoneNumber(customerDTO.getPhone());
        user.setEmail(customerDTO.getEmail());
        user.setPassword(customerDTO.getPassword());
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    public List<UserResponse> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.toUserResponse(user.orElse(null));
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User by ID " + id + " was deleted";
    }


}
