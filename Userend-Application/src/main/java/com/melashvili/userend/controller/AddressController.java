package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.UpdateAddressInfo;
import com.melashvili.userend.model.dto.response.UserAddressDTO;
import com.melashvili.userend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping("/update/address/{id}")
    public ResponseEntity<Void> updateAddress(@RequestBody UpdateAddressInfo updateAddressInfo,
                                              @PathVariable Long id) {
        addressService.updateUserAddress(updateAddressInfo, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/address/{addressId}/{userId}")
    public ResponseEntity<Void> deleteUserAddress(@PathVariable Long addressId,
                                                  @PathVariable Long userId) {
        addressService.deleteUserAddressById(addressId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/user-address/{id}")
    public ResponseEntity<UserAddressDTO> getUserAddressById(@PathVariable Long id) {
        UserAddressDTO addressDTO = addressService.getUserAddressById(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @GetMapping("/get/user-address")
    public ResponseEntity<List<UserAddressDTO>> getUserAddress() {
        List<UserAddressDTO> addressDTO = addressService.getUserAddress();
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }
}
