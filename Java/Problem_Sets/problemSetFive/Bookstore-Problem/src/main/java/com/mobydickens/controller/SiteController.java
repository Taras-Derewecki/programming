/**
 * Created by Taras on 11/20/2016.
 */

package com.mobydickens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiteController
{

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String homePage() {return "/home";}

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String searchPage() {return "search";}

    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String contactUsPage() {return "contact-us";}

    @RequestMapping(value = "/moby-dickens-login", method = RequestMethod.GET)
    public String loginPage() {return "moby-dickens-login";}

}