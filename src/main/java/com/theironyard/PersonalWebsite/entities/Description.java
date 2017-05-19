package com.theironyard.PersonalWebsite.entities;

import javax.persistence.*;

/**
 * Created by Keith on 5/19/17.
 */
@Entity
@Table(name = "descriptions")
public class Description {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Description() {

    }

    public Description(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
