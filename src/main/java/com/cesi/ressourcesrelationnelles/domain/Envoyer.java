package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "envoyer")
public class Envoyer {
    @Id
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;
    @Id
    @JoinColumn(name = "uti_id_1")
    private Utilisateur UTI_ID_1;
    @Column(name = "message")
    private String message;
    @Column(name = "dateenvoi")
    private Date dateEnvoi;
}
