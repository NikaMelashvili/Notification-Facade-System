package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.entitites.User;
import com.melashvili.userend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class CustomerController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createCustomer(@RequestBody AddCustomerDTO customerDTO) {
        userService.addOrUpdateUser(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCustomer(@RequestBody AddCustomerDTO customerDTO) {
        userService.addOrUpdateUser(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        String response = userService.deleteUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/by-number")
    public ResponseEntity<List<User>> searchByPhoneNumber(@RequestParam Integer phoneNumber) {
        List<User> users = userService.findUsersByPhoneNumber(phoneNumber);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
