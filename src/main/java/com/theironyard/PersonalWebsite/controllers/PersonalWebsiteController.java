package com.theironyard.PersonalWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Keith on 5/18/17.
 */
@Controller
public class PersonalWebsiteController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homePage(Model model) {

        return "index";
    }

}
