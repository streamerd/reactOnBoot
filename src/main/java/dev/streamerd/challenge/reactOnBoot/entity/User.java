package dev.streamerd.challenge.reactOnBoot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
//@EntityListeners(UserListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    public User(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
