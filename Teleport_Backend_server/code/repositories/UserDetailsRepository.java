package com.m1guelsb.springauth.repositories;

import com.m1guelsb.springauth.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long> {
}
