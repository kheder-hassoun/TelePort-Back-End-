package com.m1guelsb.springauth.controllers;

import com.m1guelsb.springauth.dtos.SubscriptionUpdateRequest;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/updat_subscription")
    @CrossOrigin(origins = "*")
    public User updateSubscriptionType(@RequestBody SubscriptionUpdateRequest request) {
        return userService.updateSubscriptionType(request.getSubscriptionType());
    }


}
