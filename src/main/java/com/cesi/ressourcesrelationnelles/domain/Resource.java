package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESOURCE")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "seq_post"
    )
    @SequenceGenerator(
            name = "seq_post"
    )
    @Column(name = "ID")
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DATEPUBLICATION")
    private Date datePublication;
    @Column(name = "URL")
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
