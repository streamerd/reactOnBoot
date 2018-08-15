package dev.streamerd.challenge.reactOnBoot.repository;

import dev.streamerd.challenge.reactOnBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    List <User> findByNameContainingIgnoreCase(String name);
}
