package com.cesi.ressourcesrelationnelles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    private User manager;

    @ManyToMany
    private List<User> members;
}
