package com.m1guelsb.springauth.services;

import com.m1guelsb.springauth.dtos.UserDetailsDto;
import com.m1guelsb.springauth.entities.User;
import com.m1guelsb.springauth.entities.UserDetailsEntity;
import com.m1guelsb.springauth.repositories.UserDetailsRepository;
import com.m1guelsb.springauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    public UserDetailsEntity saveUserDetails(UserDetailsDto userDetailsDto) {
        // Search for the User by username
        // Fetch the user from the database by username
        User user = (User) userRepository.findByUserName(userDetailsDto.getUserName());

        UserDetailsEntity userDetailsEntity = new UserDetailsEntity(
                user,
                userDetailsDto.getLoginTime(),
                userDetailsDto.getKernelArchitecture(),
                userDetailsDto.getKernelBitness(),
                userDetailsDto.getKernelName(),
                userDetailsDto.getKernelVersion(),
                userDetailsDto.getOperatingSystemName(),
                userDetailsDto.getOperatingSystemVersion(),
                userDetailsDto.getAppRAMUtilization(),
                userDetailsDto.getUserName(),
                userDetailsDto.getUserSpaceBitness());

        return userDetailsRepository.save(userDetailsEntity);
    }

    public List<UserDetailsDto> getAllUserDetails() {
        List<UserDetailsEntity> userDetailsEntities = userDetailsRepository.findAll();

        return userDetailsEntities.stream().map(userDetails -> new UserDetailsDto(
                userDetails.getUser().getUsername(),
                userDetails.getLoginTime(),
                userDetails.getKernelArchitecture(),
                userDetails.getKernelBitness(),
                userDetails.getKernelName(),
                userDetails.getKernelVersion(),
                userDetails.getOperatingSystemName(),
                userDetails.getOperatingSystemVersion(),
                userDetails.getAppRAMUtilization(),
                userDetails.getUserSpaceBitness()
        )).collect(Collectors.toList());
    }

}
