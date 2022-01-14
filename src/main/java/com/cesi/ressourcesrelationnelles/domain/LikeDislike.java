package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LikeDislike {
    @Id
    private Long id;
    private int  nbDislike;
    private int  nbLike;

    public int getNbDislike() {
        return nbDislike;
    }

    public void setNbDislike(int nbDislike) {
        this.nbDislike = nbDislike;
    }

    public int getNbLike() {
        return nbLike;
    }

    public void setNbLike(int nbLike) {
        this.nbLike = nbLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
