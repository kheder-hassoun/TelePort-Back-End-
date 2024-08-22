package com.m1guelsb.springauth.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUrlDetailsRequest {

    private String url;
    private String time;  // Assuming time is passed as a string, e.g., "2024-08-17T10:15:30"
    private String userName;

}
