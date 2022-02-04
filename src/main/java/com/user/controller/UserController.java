package com.user.controller;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private List<User> userList;

    @PostConstruct
    public void postConstruct() {

        userList = Arrays.asList(new User(1001L, "Veera", "798989898989")
                , new User(1002L, "Veera", "798989898989"),
                new User(1003L, "Veera", "798989898989"));

        userRepository.saveAll(userList);
    }

    // Creating a User resource
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = new User();
        user1.setName(user.getName());
        user1.setPhone(user.getPhone());
        user1.setContacts(user.getContacts());
        User savedUser = userService.saveUser(user1);
        return ResponseEntity.ok(savedUser);
    }

    // Get User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {

        Optional<User> userOptional = this.userService.getUser(userId);
        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
            //http://localhost:9002/contact/user/1001
            List<Contact> contacts =  restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
            user.setContacts(contacts);
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }
    }
}
