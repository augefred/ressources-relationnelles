package com.cesi.ressourcesrelationnelles.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commentaire {

    @Id
    @GeneratedValue
    private Long id;
    private String nameUser;
    private String nameUserParentComment;
    private String commentMessage;

    public LikeDislike getLikeDislike() {
        return likeDislike;
    }

    public void setLikeDislike(LikeDislike likeDislike) {
        this.likeDislike = likeDislike;
    }

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private LikeDislike likeDislike;








    public Commentaire(Long id, String nameUser, String nameUserParentComment, String commentMessage) {
        this.id = id;
        this.nameUser = nameUser;
        this.nameUserParentComment = nameUserParentComment;
        this.commentMessage = commentMessage;
    }



    public Commentaire() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameUserParentComment() {
        return nameUserParentComment;
    }

    public void setNameUserParentComment(String nameUserParentComment) {
        this.nameUserParentComment = nameUserParentComment;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }
}
