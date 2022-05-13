package com.cesi.ressourcesrelationnelles.dto;

import com.cesi.ressourcesrelationnelles.domain.Category;
import com.cesi.ressourcesrelationnelles.domain.Type;
import com.cesi.ressourcesrelationnelles.domain.User;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Resource {
    private Long id;

    private String title;

    private Date publishDate;

    private Date modificationDate;

    private boolean visibility;

    private String urlContent;

    private boolean validated;

    private Long viewNumber;

    private boolean archived;


    private Long author;


    private Long type;
    private Long category;

    public com.cesi.ressourcesrelationnelles.domain.Resource getModel(){
        com.cesi.ressourcesrelationnelles.domain.Resource retour = new com.cesi.ressourcesrelationnelles.domain.Resource();
        retour.setId(this.id);
        retour.setArchived(this.archived);
        User user = new User();
        user.setId(this.author);
        retour.setAuthor(user);
        Category cat = new Category();
        cat.setId(this.category);
        retour.setCategory(cat);
        retour.setTitle(this.title);
        retour.setModificationDate(this.modificationDate);
        retour.setPublishDate(this.publishDate);
        Type type = new Type();
        type.setId(this.type);
        retour.setType(type);
        retour.setValidated(this.validated);
        retour.setUrlContent(this.urlContent);
        retour.setVisibility(this.visibility);
        retour.setViewNumber(this.viewNumber);
        return retour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getUrlContent() {
        return urlContent;
    }

    public void setUrlContent(String urlContent) {
        this.urlContent = urlContent;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Long getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Long viewNumber) {
        this.viewNumber = viewNumber;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
