package com.cesi.ressourcesrelationnelles.domain;

import com.cesi.ressourcesrelationnelles.exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @Column(name = "com_id")
    private Long COM_ID;
    @Column(name = "com_datepublication")
    private String COM_DatePublication;
    @Column(name = "com_contenu")
    private String COM_Contenu;
    @OneToOne
    @JoinColumn(name = "com_id_1")
    private Commentaire COM_ID_1;
    @OneToOne
    @JoinColumn(name = "res_id")
    private Ressource RES_ID;
    @OneToOne
    @JoinColumn(name = "uti_id")
    private Utilisateur UTI_ID;

    public Commentaire getCOM_ID_1() {
        return COM_ID_1;
    }

    public void setCOM_ID_1(Commentaire COM_ID_1) {
        this.COM_ID_1 = COM_ID_1;
    }

    public Ressource getRES_ID() {
        return RES_ID;
    }

    public void setRES_ID(Ressource RES_ID) {
        this.RES_ID = RES_ID;
    }

    public Utilisateur getUTI_ID() {
        return UTI_ID;
    }

    public void setUTI_ID(Utilisateur UTI_ID) {
        this.UTI_ID = UTI_ID;
    }

    public Commentaire(Long id, String nameUser, String commentMessage) {
        this.COM_ID = id;
        this.COM_DatePublication = nameUser;
        this.COM_Contenu = commentMessage;
    }

    public Commentaire() {
    }

    public Long getCOM_ID() {
        return COM_ID;
    }

    public void setCOM_ID(Long COM_ID) {
        this.COM_ID = COM_ID;
    }

    public String getCOM_DatePublication() {
        return COM_DatePublication;
    }

    public void setCOM_DatePublication(String COM_DatePublication) {
        this.COM_DatePublication = COM_DatePublication;
    }

    public String getCOM_Contenu() {
        return COM_Contenu;
    }

    public void setCOM_Contenu(String COM_Contenu) {
        this.COM_Contenu = COM_Contenu;
    }
}
