package com.cesi.ressourcesrelationnelles.domain;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "envoyer")
@IdClass(Envoyer.class)
public class Envoyer implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @OneToOne
    @JoinColumn(name = "uti_id_1")
    private Utilisateur UTI_ID_1;
    @Column(name = "message")
    private String message;
    @Column(name = "dateenvoi")
    private Date dateEnvoi;
}
