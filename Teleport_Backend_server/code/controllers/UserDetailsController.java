package com.m1guelsb.springauth.controllers;

import com.m1guelsb.springauth.dtos.UserDetailsDto;
import com.m1guelsb.springauth.entities.UserDetailsEntity;
import com.m1guelsb.springauth.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-details")
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/add")
    public ResponseEntity<UserDetailsDto> saveUserDetails(@RequestBody UserDetailsDto userDetailsDto) {
        System.out.println(" from contrlller addd its work ");
        UserDetailsEntity savedUserDetails = userDetailsService.saveUserDetails(userDetailsDto);
        return ResponseEntity.ok(userDetailsDto);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<UserDetailsDto>> getAllUserDetails() {
        List<UserDetailsDto> userDetailsDtos = userDetailsService.getAllUserDetails();
        return ResponseEntity.ok(userDetailsDtos);
    }


}
