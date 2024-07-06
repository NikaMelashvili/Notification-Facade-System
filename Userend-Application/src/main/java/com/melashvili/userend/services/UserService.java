package com.melashvili.userend.services;

import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.model.mapper.UserMapper;
import com.melashvili.userend.repositories.AddressRepository;
import com.melashvili.userend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private AddressRepository addressRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void addUser(AddCustomerDTO customerDTO) {
        User user = UserMapper.toUser(customerDTO);
        userRepository.save(user);

        Address address = new Address();

        address.setUser(user);
        address.setEmail(customerDTO.getUser().getEmail());
        address.setStreet(customerDTO.getAddress().getStreet());
        address.setNumber(customerDTO.getUser().getPhoneNumber());
        address.setPostalCode(customerDTO.getUser().getPostal());

        addressRepository.save(address);
    }
}
