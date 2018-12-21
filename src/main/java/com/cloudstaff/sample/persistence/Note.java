package com.cloudstaff.sample.persistence;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Note {
// Notes API
    /*
    create note
    edite note
    note: title, body
    view single note
    view all notes
    delete note
    delete notes


    note: title, body, dateCreated, tags
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @ElementCollection
    private List<String> tags;

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public Note(){

    }

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
