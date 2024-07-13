package com.melashvili.userend.services;

import com.melashvili.userend.model.base.Role;
import com.melashvili.userend.model.dto.request.AddCustomerDTO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

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

    public void addOrUpdateUser(AddCustomerDTO customerDTO) {
        User user = new User();

        user.setFirstName(customerDTO.getUser().getFirstName());
        user.setLastName(customerDTO.getUser().getLastName());
        user.setAge(customerDTO.getUser().getAge());
        user.setPassword(customerDTO.getUser().getPassword());
        user.setEmail(customerDTO.getUser().getEmail());
        user.setRole(Role.USER);

        userRepository.save(user);

        Address address = new Address();
        address.setUser(user);
        address.setEmail(customerDTO.getAddress().getEmail());
        address.setStreet(customerDTO.getAddress().getStreet());
        address.setNumber(customerDTO.getAddress().getNumber());
        address.setPostalCode(customerDTO.getAddress().getPostalCode());

        addressRepository.save(address);

        Preferences preferences = new Preferences();
        preferences.setCustomerId(user);
        preferences.setEmailOpt(customerDTO.getPreferences().getEmailOpt());
        preferences.setMobileOpt(customerDTO.getPreferences().getSmsOpt());
        preferences.setPromoOpt(customerDTO.getPreferences().getPromoOpt());

        preferencesRepository.save(preferences);

        Set<Address> addresses = new HashSet<>();
        addresses.add(address);

        user.setAddresses(addresses);
        userRepository.save(user);
    }

    public String deleteUserById(Long id) {
        preferencesRepository.deleteById(id);
        addressRepository.deleteById(id);
        userRepository.deleteById(id);
        return "User by ID " + id + " was deleted";
    }

    public List<User> findUsersByPhoneNumber(Integer phoneNumber) {
        return userRepository.findUsersByPhoneNumber(phoneNumber);
    }
}
