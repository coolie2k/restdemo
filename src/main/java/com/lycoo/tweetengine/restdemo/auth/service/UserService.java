package com.lycoo.tweetengine.restdemo.auth.service;

import com.lycoo.tweetengine.restdemo.auth.model.User;
import java.util.Optional;

//The service layer is the middle layer between the presentation (controllers) and data store (repository). It abstracts business logic and data access.
public interface UserService {
    void save(User user);

    User findByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByResetToken(String resetToken);
}
