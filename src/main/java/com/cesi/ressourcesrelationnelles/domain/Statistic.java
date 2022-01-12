package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Statistic {
    @Id
    @GeneratedValue
    private long id;

    private long id_ressource;
    private int nbVues;

    public Statistic() {

    }

    public Statistic(int id, int id_ressource, int nbVues) {
        this.id = id;
        this.id_ressource = id_ressource;
        this.nbVues = nbVues;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }
}
