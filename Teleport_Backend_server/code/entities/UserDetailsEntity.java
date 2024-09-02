package com.m1guelsb.springauth.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String loginTime;
    private String kernelArchitecture;
    private String kernelBitness;
    private String kernelName;
    private String kernelVersion;
    private String operatingSystemName;
    private String operatingSystemVersion;//
    private String appRAMUtilization;
    private String userName;
    private String userSpaceBitness;

    public UserDetailsEntity(User user, String loginTime, String kernelArchitecture, String kernelBitness,
                             String kernelName, String kernelVersion, String operatingSystemName,
                             String operatingSystemVersion, String appRAMUtilization, String userName,
                             String userSpaceBitness) {
        this.user = user;
        this.loginTime = loginTime;
        this.kernelArchitecture = kernelArchitecture;
        this.kernelBitness = kernelBitness;
        this.kernelName = kernelName;
        this.kernelVersion = kernelVersion;
        this.operatingSystemName = operatingSystemName;
        this.operatingSystemVersion = operatingSystemVersion;
        this.appRAMUtilization = appRAMUtilization;
        this.userName = userName;
        this.userSpaceBitness = userSpaceBitness;
    }
}
