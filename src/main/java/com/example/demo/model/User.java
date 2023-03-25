package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="login")
    @NotBlank
    @Size(min = 1, max = 20)
    private String login;

    @Column(name="password")
    @NotBlank
    @Size(min = 1, max = 20)
    private String password;

    @Column(name="email")
    @NotBlank
    @Size(min = 1, max = 20)
    private String email;

    @Column(name="privilage")
    private String privilage;
    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.privilage = "user";
        this.email = email;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilage() {
        return privilage;
    }

    public void setPrivilage(String privilage) {
        this.privilage = privilage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
