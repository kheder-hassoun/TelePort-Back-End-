package com.m1guelsb.springauth.controllers;

import com.m1guelsb.springauth.dtos.IncrementRequest;
import com.m1guelsb.springauth.dtos.UrlDetailsResponse;
import com.m1guelsb.springauth.dtos.UserUrlDetailsRequest;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.repositories.UserRepository;
import com.m1guelsb.springauth.services.UserUrlDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/details")//dont edit this becaus its need ADMIN role and setup in the code in the authconfg.java
public class UserUrlDetailsController {

    @Autowired
    private UserUrlDetailsService userUrlDetailsService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/add")
    public ResponseEntity<String> addUserUrlDetails(@RequestBody UserUrlDetailsRequest request) {
        System.out.print(request);
        try {
            // Pass the username, URL, and time to the service
            userUrlDetailsService.addUserUrlDetails(request.getUserName(), request.getUrl(), request.getTime());
            System.out.println(" from contrlller its work ");
            return ResponseEntity.ok("User URL details added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user URL details: " + e.getMessage());
        }
    }

    @PostMapping("/increment")
    public ResponseEntity<String> incrementNumberOfEndUsers(@RequestBody IncrementRequest request) {
        try {
            userUrlDetailsService.incrementNumberOfEndUsers(request.getUserName(), request.getUrl());
            return ResponseEntity.ok("Number of end users incremented successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/details")
    public ResponseEntity<List<UrlDetailsResponse>> getUserUrlDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // Get the authenticated user's username

        // Fetch the user from the database using the username

        try {
            List<UrlDetailsResponse> details = userUrlDetailsService.getUserUrlDetails(userName);

            return ResponseEntity.ok(details);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null); // Or another appropriate error handling
        }
    }
}