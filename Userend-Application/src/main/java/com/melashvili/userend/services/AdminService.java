package com.melashvili.userend.services;

import com.melashvili.userend.model.base.Role;
import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.request.UpdateAddressInfo;
import com.melashvili.userend.model.dto.response.*;
import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.Preferences;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.model.mapper.UserMapper;
import com.melashvili.userend.repositories.AddressRepository;
import com.melashvili.userend.repositories.PreferencesRepository;
import com.melashvili.userend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminService {

    private UserRepository userRepository;

    private AddressRepository addressRepository;

    private PreferencesRepository preferencesRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setPreferencesRepository(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
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



//    public List<CustomerAddressDTO> getAllCustomersAndAddresses() {
//
//    }
}
