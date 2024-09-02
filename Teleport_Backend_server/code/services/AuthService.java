package com.m1guelsb.springauth.services;

import com.m1guelsb.springauth.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.m1guelsb.springauth.dtos.SignUpDto;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.exceptions.InvalidJwtException;
import com.m1guelsb.springauth.repositories.UserRepository;

@Service
public class AuthService implements UserDetailsService {

  @Autowired
  UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    var user = repository.findByUserName(username);
    return user;
  }

  public UserDetails signUp(SignUpDto data) throws InvalidJwtException {

    if (repository.findByUserName(data.userName()) != null) {
      throw new InvalidJwtException("Username already exists");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    UserRole temp = UserRole.USER;
    User newUser = new User(data.userName(), encryptedPassword, temp, "free");

    return repository.save(newUser);

  }

}