package com.m1guelsb.springauth.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private String userName;
    private String loginTime;
    private String kernelArchitecture;
    private String kernelBitness;
    private String kernelName;
    private String kernelVersion;
    private String operatingSystemName;
    private String operatingSystemVersion;
    private String appRAMUtilization;
    private String userSpaceBitness;
}

