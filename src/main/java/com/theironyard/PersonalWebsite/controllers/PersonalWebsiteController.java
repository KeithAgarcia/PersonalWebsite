package com.theironyard.PersonalWebsite.controllers;

import com.theironyard.PersonalWebsite.entities.JobExperience;
import com.theironyard.PersonalWebsite.repositories.JobExperienceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * Created by Keith on 5/18/17.
 */
@Controller
public class PersonalWebsiteController {


    JobExperienceRepository jobExperiences;

    public PersonalWebsiteController(JobExperienceRepository jobExperiences) {
        this.jobExperiences = jobExperiences;
    }

    @PostConstruct
    public void init(){ //delete from <table_name>
        if(jobExperiences.count() == 0){
            JobExperience jobExperience = new JobExperience();
            jobExperience.setCompanyName("Alston & Bird");
            jobExperience.setJobTitle("Application Support");
            jobExperience.setDate("Nov 2015 - Feb 2017");
            jobExperience.setDescription("Work on Applications");
            jobExperiences.save(jobExperience);

            jobExperience = new JobExperience();
            jobExperience.setCompanyName("Worldwide Tech Services");
            jobExperience.setJobTitle("Field Engineer");
            jobExperience.setDate("Nov 2013 - Nov 2015");
            jobExperience.setDescription("Hardware support" +  //one to many job descreiptions
                    "Mobile support");
            jobExperiences.save(jobExperience);

        }
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("id", jobExperiences.findFirstByOrderByDateDesc().getId());

        return "index";
    }

    @RequestMapping(path ="/job-experience/{ID}", method = RequestMethod.GET)
    public String displayJobExperience(@PathVariable("ID") int id, Model model){
        Iterable<JobExperience> jobExperience = jobExperiences.findAll();

        model.addAttribute("jobExperiences", jobExperience); //"jobExperiences" is the reference in HTML
        model.addAttribute("id", jobExperiences.findFirstByOrderByDateDesc().getId());

        return "job-experience";
    }

    @RequestMapping(path ="/about-me", method = RequestMethod.GET)
    public String displayAboutMe(Model model){
        model.addAttribute("id", jobExperiences.findFirstByOrderByDateDesc().getId());
        return "about-me";
    }

    @RequestMapping(path ="/contact", method = RequestMethod.GET)
    public String displayContact(Model model){
        model.addAttribute("id", jobExperiences.findFirstByOrderByDateDesc().getId());
        return "contact";
    }




}
