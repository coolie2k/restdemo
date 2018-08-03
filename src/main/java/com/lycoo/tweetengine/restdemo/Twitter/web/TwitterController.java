package com.lycoo.tweetengine.restdemo.Twitter.web;

import com.lycoo.tweetengine.restdemo.auth.model.User;
import com.lycoo.tweetengine.restdemo.auth.service.SecurityService;
import com.lycoo.tweetengine.restdemo.auth.service.UserService;
import com.lycoo.tweetengine.restdemo.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TwitterController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value={"search"}, method = RequestMethod.GET)
    public ModelAndView getsearch(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //defines a /register endpoint that handles POST requests. This will be used to save the user to database.
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public ModelAndView processSearch(@ModelAttribute(value="query") @Valid User userForm)
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/");
        return modelAndView;
    }

}
