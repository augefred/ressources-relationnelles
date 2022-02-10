package com.cesi.ressourcesrelationnelles.domain;


import javax.persistence.*;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "seq_post"
    )
    @SequenceGenerator(
            name = "seq_post"
    )
    @Column(name = "uti_id")
    private long UTI_ID;
    @Column(name = "uti_nom")
    private String UTI_Nom;
    @Column(name = "uti_prenom")
    private String UTI_Prenom;
    /*@Column(name = "res_datemodification")
    private Date RES_DateModification;
    @Column(name = "res_visibilite")
    private boolean RES_Visibilite;
    @Column(name = "res_repertoirecontenu")
    private String RES_URL;
    @Column(name = "res_validation")
    private String RES_Validation;
    @Column(name = "res_nbvues")
    private String RES_NbVues;
    @Column(name = "categ_id")
    private String CATEG_ID;
    //@Column(name = "uti_id")
    @ManyToOne
    @JoinColumn(name="uti_id")
    private User UTI_ID;




    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;
    private String password;
    private Title title;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private Address address;*/

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom) {
        this.UTI_Nom = nom;
        this.UTI_Prenom = prenom;
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/



    public String getFullName() {
        return buildFullName(this.UTI_Prenom, this.UTI_Nom);
    }





    /*public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    private String buildFullName(String firstName, String lastName) {
        return firstName + lastName;
    }

    /*public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }*/
}
