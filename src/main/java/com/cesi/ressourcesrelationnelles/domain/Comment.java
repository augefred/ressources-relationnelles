package com.cesi.ressourcesrelationnelles.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private Long id;

    private Date publishDate;

    private String content;

    @ManyToOne
    private Comment parent;
}
