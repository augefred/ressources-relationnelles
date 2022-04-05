package com.cesi.ressourcesrelationnelles.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private Long id;

    private String name;

    private String description;
}
