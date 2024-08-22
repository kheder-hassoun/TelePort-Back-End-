package com.m1guelsb.springauth.services;

import com.m1guelsb.springauth.dtos.UrlDetailsResponse;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.entities.UserUrlDetails;
import com.m1guelsb.springauth.repositories.UserUrlDetailsRepository;
import com.m1guelsb.springauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserUrlDetailsService {

    @Autowired
    private UserUrlDetailsRepository userUrlDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    public void addUserUrlDetails(String userName, String url, String time) {
        System.out.println(" from service its work ");
        System.out.printf(userName);
        System.out.printf(url);
        System.out.printf(time);
        // Fetch the user from the database by username
        User user = (User) userRepository.findByUserName(userName);

        // Convert the time string to LocalDateTime
        //LocalDateTime generatedTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Create a new UserUrlDetails record
        UserUrlDetails userUrlDetails = new UserUrlDetails(user, url, time, 0);

        // Save the record in the database
        userUrlDetailsRepository.save(userUrlDetails);
    }

    @Transactional
    public void incrementNumberOfEndUsers(String userName, String url) {
        User user = (User) userRepository.findByUserName(userName);
        if (user != null) {
            UserUrlDetails userUrlDetails = userUrlDetailsRepository.findByUserAndUrl(user, url);
            if (userUrlDetails != null) {
                userUrlDetails.setNumberOfEndUsers(userUrlDetails.getNumberOfEndUsers() + 1);
                userUrlDetailsRepository.save(userUrlDetails);
            } else {
                throw new RuntimeException("URL details not found for user: " + userName);
            }
        } else {
            throw new RuntimeException("User not found: " + userName);
        }
    }


    public List<UrlDetailsResponse> getUserUrlDetails(String userName) {
        User user = (User) userRepository.findByUserName(userName);
        List<UserUrlDetails> userUrlDetailsList = userUrlDetailsRepository.findByUser(user);

        return userUrlDetailsList.stream()
                .map(details -> new UrlDetailsResponse(details.getUrl(), details.getGeneratedTime(), details.getNumberOfEndUsers()))
                .collect(Collectors.toList());
    }

}