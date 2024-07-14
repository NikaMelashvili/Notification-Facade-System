package com.melashvili.userend.facade;

import com.melashvili.userend.model.dto.response.UserAddressDTO;
import com.melashvili.userend.model.entitites.Address;
import com.melashvili.userend.model.entitites.User;

public class AddressAbstraction {

    public static UserAddressDTO getUserAddressDTO(User user, Address address) {
        UserAddressDTO userAddressDTO = new UserAddressDTO();

        userAddressDTO.setUserId(user.getId());
        userAddressDTO.setFirstName(user.getFirstName());
        userAddressDTO.setLastName(user.getLastName());
        userAddressDTO.setEmail(address.getEmail());
        userAddressDTO.setStreet(address.getStreet());
        userAddressDTO.setPhone(address.getNumber());

        return userAddressDTO;
    }

}
