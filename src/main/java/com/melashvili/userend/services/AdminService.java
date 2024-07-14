package com.melashvili.userend.services;

import com.melashvili.userend.model.dto.response.UserResponseDTO;
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

    public List<UserResponseDTO> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(UserMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.toUserResponse(user.orElse(null));
    }
}
