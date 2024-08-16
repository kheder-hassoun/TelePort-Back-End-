package com.m1guelsb.springauth.services;

import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User updateSubscriptionType(String subscriptionType) {
        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // Get the authenticated user's username

        // Fetch the user from the database using the username
        User user = (User) userRepository.findByUserName(userName);


        // Update the subscription type
        user.setSubscriptionType(subscriptionType);
        return userRepository.save(user);
    }



}
