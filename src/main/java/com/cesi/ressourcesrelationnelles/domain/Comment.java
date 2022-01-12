package com.cesi.ressourcesrelationnelles.domain;

public class Comment {
    public Comment(int id, String nameUser, String nameUserParentComment, String commentMessage) {
        this.id = id;
        this.nameUser = nameUser;
        this.nameUserParentComment = nameUserParentComment;
        this.commentMessage = commentMessage;
    }

    public int id;
    public String nameUser;
    public String nameUserParentComment;
    public String commentMessage;

    public Comment() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
