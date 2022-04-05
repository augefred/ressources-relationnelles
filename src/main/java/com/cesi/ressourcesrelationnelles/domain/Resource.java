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
public class Resource {
    @Id
    private Long id;

    private String title;

    private Date publishDate;

    private Date modificationDate;

    private boolean visibility;

    private String urlContent;

    private boolean validated;

    private Long viewNumber;

    private boolean archived;

    @ManyToOne
    private User author;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Category category;
}
