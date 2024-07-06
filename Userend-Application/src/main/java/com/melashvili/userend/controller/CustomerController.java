package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.request.AddCustomerDTO;
import com.melashvili.userend.model.dto.request.PreferencesRegisterDTO;
import com.melashvili.userend.services.AdminService;
import com.melashvili.userend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class CustomerController {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody AddCustomerDTO customerDTO) {
        adminService.addOrUpdateCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/consumer")
    public ResponseEntity<Void> updateCustomer(@RequestBody AddCustomerDTO customerDTO) {
        adminService.addOrUpdateCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        String response = adminService.deleteUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
