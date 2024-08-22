package com.m1guelsb.springauth.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "user_url_details")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserUrlDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String url;

    private String generatedTime;

    private int numberOfEndUsers;

    public UserUrlDetails(User user, String url, String generatedTime, int numberOfEndUsers) {
        this.user = user;
        this.url = url;
        this.generatedTime = generatedTime;
        this.numberOfEndUsers = numberOfEndUsers;
    }


}