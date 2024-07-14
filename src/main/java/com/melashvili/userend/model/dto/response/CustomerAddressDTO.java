package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddressDTO {
    private UserResponseDTO user;
    private AddressResponseDTO address;
}
