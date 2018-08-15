package dev.streamerd.challenge.reactOnBoot.service;

import dev.streamerd.challenge.reactOnBoot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     List<User> findByNameIgnoreCase(String name);
     List<User> findAll();

     User save(User newUser);
}
