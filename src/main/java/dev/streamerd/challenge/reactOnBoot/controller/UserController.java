package dev.streamerd.challenge.reactOnBoot.controller;
import dev.streamerd.challenge.reactOnBoot.entity.User;
import dev.streamerd.challenge.reactOnBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> users = userService.findAll();
        return users;
    }

    // This method makes search on userRepository and fetches all users' data that contains the name without case sensitivity.
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findUsersByName(@RequestParam(value = "name") final String name){
        List<User> users = userService.findByNameIgnoreCase(name);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody final User user){
        User newUser = new User(user.getName(), user.getPhoneNumber(), user.getAddress());
        userService.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
