package com.example.Foodmanagement_system.controler;

import java.util.List;

import com.example.Foodmanagement_system.exception.ResourceNotFoundException;
import com.example.Foodmanagement_system.model.User;
import com.example.Foodmanagement_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/user")
public class UserControler {

    @Autowired
    private UserRepository userRepository;

    // get all users
    @GetMapping("/")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // post to user table
    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

        //update user
        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user)
        {
            User usr = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
            usr.setUsername(user.getUsername());
            usr.setPassword(user.getPassword());
  
            User usrr = userRepository.save(usr);
            return ResponseEntity.ok(usrr);
        }

}
