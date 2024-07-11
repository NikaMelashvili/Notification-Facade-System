package com.melashvili.userend.services;

import com.melashvili.userend.facade.AddressAbstraction;
import com.melashvili.userend.model.dto.request.UpdateAddressInfo;
import com.melashvili.userend.model.dto.response.UserAddressDTO;
import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.repositories.AddressRepository;
import com.melashvili.userend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public UserAddressDTO getUserAddressById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        Address address = addressRepository.findById(id).orElse(null);

        if (user == null || address == null) {
            return null;
        }

        return AddressAbstraction.getUserAddressDTO(user, address);

    }

    public List<UserAddressDTO> getUserAddress() {
        List<UserAddressDTO> userAddressDTOS = new ArrayList<>();
        List<User> usersList = (List<User>) userRepository.findAll();
        List<Address> addressList = addressRepository.findAll();

        for (User user : usersList) {
            for (Address address : addressList) {
                if (address.getUser().getId().equals(user.getId())) {
                    UserAddressDTO userAddressDTO = AddressAbstraction.getUserAddressDTO(user, address);

                    userAddressDTO.setPostalCode(address.getPostalCode());
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
        address.setEmail(updateAddressInfo.getEmail());
        address.setStreet(updateAddressInfo.getStreet());
        address.setNumber(updateAddressInfo.getPhone());
        address.setPostalCode(updateAddressInfo.getPostal());

        user.setEmail(updateAddressInfo.getEmail());

        userRepository.save(user);
        addressRepository.save(address);
    }

    public void deleteUserAddressById(Long addressId, Long userId) {
        userRepository.deleteById(userId);
        addressRepository.deleteById(addressId);
    }

}
