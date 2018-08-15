package dev.streamerd.challenge.reactOnBoot;

import dev.streamerd.challenge.reactOnBoot.entity.User;
import dev.streamerd.challenge.reactOnBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Below are mock data, to be loaded initially at the application creation.
        userRepository.save(new User("Ali", "+902120000000", "Turkey"));
        userRepository.save(new User("Ada", "+109006598745-1223", "England"));
        userRepository.save(new User("Cahit", "+902120000000", "Turkey"));
        userRepository.save(new User("Alan", "009891212-1222", "England"));

        System.out.println("\nRecords Saved.");
    }
}
