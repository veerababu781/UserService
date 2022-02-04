package com.user.service;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.user.entity.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserServiceImpl implements UserService{

    /*List<User> list = Stream.of(
            new User(1212L, "Veera","9876543210"),
            new User(1213L, "Sandeep","9876543211"),
            new User(1213L, "Mastan","98745612356")).collect(Collectors.toList());*/

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUser(Long id) {
     /*   return list.stream().
                filter(user -> user.getUserId().equals(id)).
                findAny().
                orElse(null);*/
        return userRepository.findById(id);
    }
}
