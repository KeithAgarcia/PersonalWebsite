package com.theironyard.PersonalWebsite.controllers;

import com.theironyard.PersonalWebsite.repositories.PersonalWebsiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Keith on 5/18/17.
 */
@Controller
public class PersonalWebsiteController {
    PersonalWebsiteRepository personalWebsiteRepository;



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {

        return "index";
    }

    @RequestMapping(path ="/job-experience/1", method = RequestMethod.GET)
    public String displayJobExperience(Model model){
        return "job-experience";
    }

    @RequestMapping(path ="/about-me", method = RequestMethod.GET)
    public String displayAboutMe(Model model){
        return "about-me";
    }

    @RequestMapping(path ="/contact", method = RequestMethod.GET)
    public String displayContact(Model model){
        return "contat";
    }




}
