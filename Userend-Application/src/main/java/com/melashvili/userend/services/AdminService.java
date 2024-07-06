package com.melashvili.userend.services;

import com.melashvili.userend.model.base.Role;
import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.request.UpdateAddressInfo;
import com.melashvili.userend.model.dto.response.*;
import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.model.mapper.UserMapper;
import com.melashvili.userend.repositories.AddressRepository;
import com.melashvili.userend.repositories.PreferencesRepository;
import com.melashvili.userend.repositories.UserPreferencesRepository;
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

    private UserPreferencesRepository userPreferencesRepository;

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

    @Autowired
    public void setUserPreferencesRepository(UserPreferencesRepository userPreferencesRepository) {
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public void addOrUpdateCustomer(AddCustomerDTO customerDTO) {
        User user = new User();
        user.setFirstName(customerDTO.getUser().getFirstName());
        user.setLastName(customerDTO.getUser().getLastName());
        user.setPhoneNumber(customerDTO.getUser().getPhoneNumber());
        user.setPassword(customerDTO.getUser().getPassword());
        user.setEmail(customerDTO.getUser().getEmail());
        user.setRole(Role.USER);
        userRepository.save(user);
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

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User by ID " + id + " was deleted";
    }

    public UserAddressDTO getUserAddressById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        Address address = addressRepository.findById(id).orElse(null);

        if (user == null || address == null) {
            return null;
        }

        UserAddressDTO userAddressDTO = new UserAddressDTO();
        userAddressDTO.setUserId(user.getId());
        userAddressDTO.setFirstName(user.getFirstName());
        userAddressDTO.setLastName(user.getLastName());
        userAddressDTO.setEmail(user.getEmail());
        userAddressDTO.setPhone(user.getPhoneNumber());
        userAddressDTO.setStreet(address.getStreet());

        return userAddressDTO;
    }

    public List<UserAddressDTO> getUserAddress() {
        List<UserAddressDTO> userAddressDTOS = new ArrayList<>();
        List<User> usersList = (List<User>) userRepository.findAll();
        List<Address> addressList = addressRepository.findAll();

        for (User user : usersList) {
            for (Address address : addressList) {
                if (address.getUser().getId().equals(user.getId())) {
                    UserAddressDTO userAddressDTO = new UserAddressDTO();

                    userAddressDTO.setUserId(user.getId());
                    userAddressDTO.setFirstName(user.getFirstName());
                    userAddressDTO.setLastName(user.getLastName());
                    userAddressDTO.setEmail(user.getEmail());
                    userAddressDTO.setPhone(user.getPhoneNumber());
                    userAddressDTO.setStreet(address.getStreet());
                    userAddressDTOS.add(userAddressDTO);

                    break;
                }
            }
        }

        return userAddressDTOS;
    }


    public void updateUserAddress(UpdateAddressInfo updateAddressInfo, Long id) {
        User user = userRepository.findById(id).orElse(null);
        Address address = addressRepository.findById(id).orElse(null);

        if (user == null || address == null) {
            throw new IllegalArgumentException("User/Address not found");
        }

        address.setUser(user);
        address.setEmail(updateAddressInfo.getEmail());
        address.setStreet(updateAddressInfo.getStreet());
        address.setNumber(updateAddressInfo.getPhone());
        address.setPostalCode(updateAddressInfo.getPostal());

        user.setEmail(updateAddressInfo.getEmail());
        user.setPhoneNumber(updateAddressInfo.getPhone());
        user.setPostal(updateAddressInfo.getPostal());

        userRepository.save(user);
        addressRepository.save(address);
    }

    public void deleteUserAddressById(Long addressId, Long userId) {
        userRepository.deleteById(userId);
        addressRepository.deleteById(addressId);
    }

    public List<CustomerAddressDTO> getAllCustomersAndAddresses() {

    }
}
