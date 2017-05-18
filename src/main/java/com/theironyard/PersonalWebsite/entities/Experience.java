package com.theironyard.PersonalWebsite.entities;

import javax.persistence.*;

/**
 * Created by Keith on 5/18/17.
 */
@Entity
@Table(name = "experiences")
public class Experience {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String companyName;

    @Column(nullable = false)
    String jobTitle;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String description;


}
