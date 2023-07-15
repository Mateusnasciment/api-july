package com.example.apijuly.models.User;

import com.example.apijuly.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
    })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =(50))
    private String username;

    @Column(nullable = false, length =(50))
    @Email
    private String email;

    @Column(nullable = false, length =(50))
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name= "user_roles",
         joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns =  @JoinColumn(name = "role_ id"))
    private Set<Role> roles = new HashSet<>();
    public User() {

    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
