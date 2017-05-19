package com.theironyard.PersonalWebsite.controllers;

import com.theironyard.PersonalWebsite.entities.Description;
import com.theironyard.PersonalWebsite.entities.JobExperience;
import com.theironyard.PersonalWebsite.repositories.DescriptionRepository;
import com.theironyard.PersonalWebsite.repositories.JobExperienceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 5/18/17.
 */
@Controller
public class PersonalWebsiteController {
    DescriptionRepository descriptions;

    JobExperienceRepository jobExperiences;

    public PersonalWebsiteController(DescriptionRepository descriptions, JobExperienceRepository jobExperiences) {
        this.descriptions = descriptions;
        this.jobExperiences = jobExperiences;
    }

    @PostConstruct
    public void init(){ //delete from <table_name>
        if(jobExperiences.count() == 0){
            JobExperience jobExperience = new JobExperience();
            jobExperience.setCompanyName("Alston & Bird");
            jobExperience.setJobTitle("Application Support");
            jobExperience.setDate("Nov 2015 - Feb 2017");

            // make a new list that will hold job descriptions
            List<Description> jobDuties = new ArrayList<>();

            // add our new descriptions to that list
            jobDuties.add(new Description("Work on Applications"));
            jobDuties.add(new Description("Do some other stuff"));

            // save the descriptions to your repository
            // this must happen before you can assign these objects
            // to your jobExperience object
            descriptions.save(jobDuties);

            // once we've saved our descriptions, we can assign them
            // to a jobExperience.
            jobExperience.setDescriptions(jobDuties);

            // after we modify our jobExperience, we save it.
            jobExperiences.save(jobExperience);

            // repeat this task for every jobExperience that you want to add.

            jobExperience = new JobExperience();
            jobExperience.setCompanyName("Worldwide Tech Services");
            jobExperience.setJobTitle("Field Engineer");
            jobExperience.setDate("Nov 2013 - Nov 2015");
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
