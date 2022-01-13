package com.cesi.ressourcesrelationnelles.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nameUser;
    private String nameUserParentComment;
    private String commentMessage;

    public Comment(Long id, String nameUser, String nameUserParentComment, String commentMessage) {
        this.id = id;
        this.nameUser = nameUser;
        this.nameUserParentComment = nameUserParentComment;
        this.commentMessage = commentMessage;
    }



    public Comment() {
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
