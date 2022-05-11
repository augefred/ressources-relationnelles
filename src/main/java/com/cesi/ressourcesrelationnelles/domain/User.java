package com.cesi.ressourcesrelationnelles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private long id;

    private String firstName;

    private String lastName;

    private Date bornDate;

    private String password;

    private String email;

    private String phone;

    private String urlAvatar;

    private String description;

    private String sexe;

    private int zipCode;

    private String address;

    private String city;

    private boolean activated;

    @ManyToOne
    private Role role;

    public User(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    //private Long ROUTI_ID;


}
