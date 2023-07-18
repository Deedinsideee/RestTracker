package com.example.resttracker.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_sequence",allocationSize = 1)
public class User extends GenericModel {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


}
