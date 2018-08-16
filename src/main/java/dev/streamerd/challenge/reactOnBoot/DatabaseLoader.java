package dev.streamerd.challenge.reactOnBoot;

import dev.streamerd.challenge.reactOnBoot.entity.User;
import dev.streamerd.challenge.reactOnBoot.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private Logger log = Logger.getLogger(DatabaseLoader.class.getName());
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Below are mock data, to be loaded initially at the application creation.

        System.out.println("=========================================================================");


        userRepository.save(new User("Khalessi", "+902120000000", "Turkey"));
        userRepository.save(new User("Ali", "+902120000000", "Turkey"));
        userRepository.save(new User("Ada ", "+109006598745-1223", "England"));
        userRepository.save(new User("Felix ", "+109006598745-1223", "England"));
        userRepository.save(new User("Cahit Arf", "+902120000000", "Turkey"));
        userRepository.save(new User("Alan Turing", "00989121432", "England"));
        userRepository.save(new User("Donald", "00984521222", "England"));
        userRepository.save(new User("Alania", "009891212-1222", "England"));
        userRepository.save(new User("Adamon", "009891212-1222", "England"));


        System.out.println("=========================================================================");

        userRepository.findAll().stream()
                .forEach(user -> {
                    log.info("\n" + user.getName() + "  - -  just saved to H2.");
                });

        System.out.println("\nRecords Saved.");
    }
}
