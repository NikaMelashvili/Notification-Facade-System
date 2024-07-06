package com.melashvili.userend.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDTO {
    private Long id;
    private String email;
    private String street;
    private Integer number;
    private Integer postalCode;
}
