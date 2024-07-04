package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.response.UserResponse;
import com.melashvili.userend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/consumer")
    public ResponseEntity<Void> createCustomer(@RequestBody AddCustomerDTO customerDTO) {
        adminService.addOrUpdateCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/consumer")
    public ResponseEntity<Void> updateCustomer(@RequestBody AddCustomerDTO customerDTO) {
        adminService.addOrUpdateCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> users = adminService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        String response = adminService.deleteUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
