package com.user.service;

import com.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public interface UserService {

    public User saveUser(User user);
    public Optional<User> getUser(Long id);
}
