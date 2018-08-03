package com.lycoo.tweetengine.restdemo.auth.web;

import com.lycoo.tweetengine.restdemo.auth.model.User;
import com.lycoo.tweetengine.restdemo.auth.service.SecurityService;
import com.lycoo.tweetengine.restdemo.auth.service.UserService;
import com.lycoo.tweetengine.restdemo.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    // defines a /register endpoint that handles GET requests. This will be used to serve the registration template.
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(Model model) {
        User userForm = new User();
        model.addAttribute("userForm", userForm);

        return "/registration";
    }

    //defines a /register endpoint that handles POST requests. This will be used to save the user to database.
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(@ModelAttribute(value="userForm") @Valid User userForm, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        modelAndView.addObject("successMessage", "User has been registered successfully");
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String show_login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String post_login () {return "/index";}

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "/index";
    }
}
