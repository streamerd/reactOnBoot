package dev.streamerd.challenge.reactOnBoot.service.impl;

import dev.streamerd.challenge.reactOnBoot.entity.User;
import dev.streamerd.challenge.reactOnBoot.repository.UserRepository;
import dev.streamerd.challenge.reactOnBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("projectService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findByNameIgnoreCase(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User newUser) {
        return repository.save(newUser);
    }
}
