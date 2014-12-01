package edu.nu.cs.web.controller;

import edu.nu.cs.model.entity.User;
import edu.nu.cs.model.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasnain on 11/26/14.
 */
@Controller
@RequestMapping("/secure")
public class AuthenticationController {

    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "/login")
    private String login(ModelMap models){
        return "auth/login";
    }

    @RequestMapping(value = "/register")
    private String registerForm(ModelMap models){
        return "auth/register";
    }

}
