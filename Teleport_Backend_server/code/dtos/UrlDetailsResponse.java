package com.m1guelsb.springauth.dtos;

import java.time.Instant;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDetailsResponse {


    private String url;
    private String time;
    private int numberOfEndUsers;

    public UrlDetailsResponse(String url, String time, int numberOfEndUsers) {
        this.url = url;
        this.time = time;
        this.numberOfEndUsers = numberOfEndUsers;
    }


}
