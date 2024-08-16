package com.m1guelsb.springauth.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.m1guelsb.springauth.config.auth.TokenProvider;
import com.m1guelsb.springauth.dtos.SignInDto;
import com.m1guelsb.springauth.dtos.SignUpDto;
import com.m1guelsb.springauth.dtos.JwtDto;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private AuthService service;
  @Autowired
  private TokenProvider tokenService;

//  @Autowired
//  private UserService userService;
//  @PostMapping("/signup")
//  public ResponseEntity<?> signUp(@ModelAttribute @Valid SignUpDto data) {
//    service.signUp(data);
//    return ResponseEntity.status(HttpStatus.CREATED).build();
//  }
//
//  @PostMapping("/signin")
//  public ResponseEntity<JwtDto> signIn(@RequestParam("userName") String userName,
//                                       @RequestParam("password") String password) {
//    var usernamePassword = new UsernamePasswordAuthenticationToken(userName, password);
//
//    var authUser = authenticationManager.authenticate(usernamePassword);
//
//    var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
//
//    return ResponseEntity.ok(new JwtDto(accessToken));
//  }
  @PostMapping("/signup")
  @CrossOrigin(origins = "*")
  public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) {
    // Register the user and get UserDetails
    User user = (User) service.signUp(data);

    // Generate the access token using the UserDetails object
    String accessToken = tokenService.generateAccessToken(user);

    // Get the subscription type from the User object
    String subscriptionType = user.getSubscriptionType();

    // Return the token, username, and subscription type in the response
    return ResponseEntity.status(HttpStatus.CREATED).body(new JwtDto(accessToken, user.getUsername(), subscriptionType));
  }

  @PostMapping("/signin")
  @CrossOrigin(origins = "*")
  public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());

    var authUser = authenticationManager.authenticate(usernamePassword);

    // Get the authenticated User object
    User authenticatedUser = (User) authUser.getPrincipal();

    // Extract the subscription type from the User object
    String subscriptionType = authenticatedUser.getSubscriptionType();

    // Generate the JWT access token
    var accessToken = tokenService.generateAccessToken(authenticatedUser);

    // Return the JwtDto with the subscription type
    return ResponseEntity.ok(new JwtDto(accessToken, data.userName(), subscriptionType));
  }





}