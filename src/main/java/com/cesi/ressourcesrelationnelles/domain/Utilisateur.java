package com.cesi.ressourcesrelationnelles.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
    @Column(name = "uti_adresse")
    private String UTI_Adresse;
    @Column(name = "uti_ville")
    private String UTI_Ville;
    @Column(name = "uti_activation")
    private boolean UTI_Activation;
    @Column(name = "routi_id")
    private Long ROUTI_ID;
    public Utilisateur(){

    }

    public Utilisateur(String nom, String prenom){
        this.UTI_Nom = nom;
        this.UTI_Prenom = prenom;
    }

    public Utilisateur(String nom, String prenom, Date dateNaissance, String motDePasse, String email, String numTel, String civilite, int codePostal, String adresse, String ville){

    }

    /*public Utilisateur(String nom, String prenom, Date datenaissance, String mail, String tel, String avatar, String civilite, int codePostal, boolean active){
        this.UTI_Nom = nom;
        this.UTI_Prenom = prenom;
        this.UTI_DateNaissance = datenaissance;
        this.UTI_Mail = mail;
        this.UTI_NumeroTel = tel;
        this.UTI_RepertoireAvatar = avatar;
        this.UTI_Civilite = civilite;
        this.UTI_CodePostal = codePostal;
        this.UTI_Activation = active;
    }*/

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

    public Date getUTI_DateNaissance() {
        return UTI_DateNaissance;
    }

    public void setUTI_DateNaissance(Date UTI_DateNaissance) {
        this.UTI_DateNaissance = UTI_DateNaissance;
    }

    public String getUTI_Mail() {
        return UTI_Mail;
    }

    public void setUTI_Mail(String UTI_Mail) {
        this.UTI_Mail = UTI_Mail;
    }

    public String getUTI_NumeroTel() {
        return UTI_NumeroTel;
    }

    public void setUTI_NumeroTel(String UTI_NumeroTel) {
        this.UTI_NumeroTel = UTI_NumeroTel;
    }

    public String getUTI_RepertoireAvatar() {
        return UTI_RepertoireAvatar;
    }

    public void setUTI_RepertoireAvatar(String UTI_RepertoireAvatar) {
        this.UTI_RepertoireAvatar = UTI_RepertoireAvatar;
    }

    public String getUTI_Description() {
        return UTI_Description;
    }

    public void setUTI_Description(String UTI_Description) {
        this.UTI_Description = UTI_Description;
    }

    public String getUTI_Civilite() {
        return UTI_Civilite;
    }

    public void setUTI_Civilite(String UTI_Civilite) {
        this.UTI_Civilite = UTI_Civilite;
    }

    public int getUTI_CodePostal() {
        return UTI_CodePostal;
    }

    public void setUTI_CodePostal(int UTI_CodePostal) {
        this.UTI_CodePostal = UTI_CodePostal;
    }

    public boolean isUTI_Activation() {
        return UTI_Activation;
    }

    public void setUTI_Activation(boolean UTI_Activation) {
        this.UTI_Activation = UTI_Activation;
    }

    public Long getROUTI_ID() {
        return ROUTI_ID;
    }

    public void setROUTI_ID(Long ROUTI_ID) {
        this.ROUTI_ID = ROUTI_ID;
    }

    public String getUTI_MotDePasse() {
        return UTI_MotDePasse;
    }

    public void setUTI_MotDePasse(String UTI_MotDePasse) {
        this.UTI_MotDePasse = UTI_MotDePasse;
    }
}
