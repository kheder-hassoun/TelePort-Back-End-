package com.m1guelsb.springauth.repositories;
import com.m1guelsb.springauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.m1guelsb.springauth.entities.UserUrlDetails;

import java.util.List;

public interface UserUrlDetailsRepository extends JpaRepository<UserUrlDetails, Long> {
    UserUrlDetails findByUserAndUrl(User user, String url);
    List<UserUrlDetails> findByUser(User user);
}