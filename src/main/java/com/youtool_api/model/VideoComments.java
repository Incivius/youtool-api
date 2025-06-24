package com.youtool_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class VideoComments {

    @Id
    private String id;

    private String author;
    private String text;
    private String published_at;
    private Integer likes;

    public String getId() { return id; }
    public String getAuthor() { return author; }
    public String getText() { return text; }
    public String getPublished_at() { return published_at; }
    public Integer getLikes() { return likes; }
    
    public void setId(String id) { this.id = id; }
    public void setAuthor(String author) { this.author = author; }
    public void setText(String text) { this.text = text; }
    public void setPublished_at(String published_at) { this.published_at = published_at; }
    public void setLikes(Integer likes) { this.likes = likes; }
    
}
