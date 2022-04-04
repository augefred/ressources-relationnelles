package com.cesi.ressourcesrelationnelles.domain;

import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "mes_id")
    private Long MES_ID;
    @ManyToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur MES_Envoyeur;
    @ManyToOne
    @JoinColumn(name = "uti_id_1")
    private Utilisateur MES_Destinataire;
    @Column(name = "mes_datepublication")
    private Date MES_DatePublication;
    @Column(name = "mes_contenu")
    private String MES_Contenu;

    public Message() {
    }

    public Long getMES_ID() {
        return MES_ID;
    }

    public void setMES_ID(Long MES_ID) {
        this.MES_ID = MES_ID;
    }

    public Utilisateur getMES_Envoyeur() {
        return MES_Envoyeur;
    }

    public void setMES_Envoyeur(Utilisateur MES_Envoyeur) {
        this.MES_Envoyeur = MES_Envoyeur;
    }

    public Utilisateur getMES_Destinataire() {
        return MES_Destinataire;
    }

    public void setMES_Destinataire(Utilisateur MES_Destinataire) {
        this.MES_Destinataire = MES_Destinataire;
    }

    public Date getMES_DatePublication() {
        return MES_DatePublication;
    }

    public void setMES_DatePublication(Date MES_DatePublication) {
        this.MES_DatePublication = MES_DatePublication;
    }

    public String getMES_Contenu() {
        return MES_Contenu;
    }

    public void setMES_Contenu(String MES_Contenu) {
        this.MES_Contenu = MES_Contenu;
    }
}
