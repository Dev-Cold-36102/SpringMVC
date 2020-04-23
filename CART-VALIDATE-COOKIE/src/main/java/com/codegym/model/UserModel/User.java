package com.codegym.model.UserModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

//@Entity
//@Table(name = "Users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;

//    @NotEmpty
//    @NotBlank(message = "password can not contain blank")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
