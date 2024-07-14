package com.melashvili.userend.controller;

import com.melashvili.userend.model.dto.response.UserResponseDTO;
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

    @GetMapping("/get/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> users = adminService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/user")
    public ResponseEntity<UserResponseDTO> getUserById(@RequestParam Long id) {
        UserResponseDTO user = adminService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
