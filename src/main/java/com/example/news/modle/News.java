package com.example.news.modle;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News{
    @Autowired
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String content;
    private int reviewed;
    private int publisherid;

    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
        reviewed = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int isReviewed() {
        return reviewed;
    }

    public void setReviewed(int reviewed) {
        this.reviewed = reviewed;
    }
}
