package com.theironyard.PersonalWebsite.entities;

import javax.persistence.*;

/**
 * Created by Keith on 5/18/17.
 */
@Entity
@Table(name = "jobExperiences")
public class JobExperience {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
