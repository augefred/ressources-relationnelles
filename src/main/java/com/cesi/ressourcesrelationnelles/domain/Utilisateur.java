package com.cesi.ressourcesrelationnelles.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @Column(name = "uti_id")
    private long UTI_ID;
    @Column(name = "uti_nom")
    private String UTI_Nom;
    @Column(name = "uti_prenom")
    private String UTI_Prenom;

    public Date getUTI_DateNaissance() {
        return UTI_DateNaissance;
    }

    public void setUTI_DateNaissance(Date UTI_DateNaissance) {
        this.UTI_DateNaissance = UTI_DateNaissance;
    }

    @Column(name = "uti_datenaissance")
    private Date UTI_DateNaissance;
    @Column(name = "uti_motdepasse")
    private String UTI_MotDePasse;
    @Column(name = "uti_mail")
    private String UTI_Mail;
    @Column(name = "uti_numerotel")
    private String UTI_NumeroTel;
    @Column(name = "uti_repertoireavatar")
    private String UTI_RepertoireAvatar;
    @Column(name = "uti_description")
    private String UTI_Description;
    @Column(name = "uti_civilite")
    private String UTI_Civilite;
    @Column(name = "uti_codepostal")
    private int UTI_CodePostal;
    @Column(name = "uti_activation")
    private boolean UTI_Activation;
    @OneToOne
    @JoinColumn(name = "routi_id")
    private RoleUtilisateur ROUTI_ID;

    public Utilisateur(){

    }

    public Utilisateur(String nom, String prenom){
        this.UTI_Nom = nom;
        this.UTI_Prenom = prenom;
    }

    public long getUTI_ID() {
        return UTI_ID;
    }

    public void setUTI_ID(long UTI_ID) {
        this.UTI_ID = UTI_ID;
    }

    public String getUTI_Nom() {
        return UTI_Nom;
    }

    public void setUTI_Nom(String UTI_Nom) {
        this.UTI_Nom = UTI_Nom;
    }

    public String getUTI_Prenom() {
        return UTI_Prenom;
    }

    public void setUTI_Prenom(String UTI_Prenom) {
        this.UTI_Prenom = UTI_Prenom;
    }
}
