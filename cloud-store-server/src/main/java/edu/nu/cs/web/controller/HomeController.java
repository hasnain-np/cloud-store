package edu.nu.cs.web.controller;

import edu.nu.cs.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasnain on 12/1/2014.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @RequestMapping(value={"/", "/home"})
    public String printHello(ModelMap model) {
        /*model.addAttribute("name", "Talha !");

        List<User> users = userRepository.findAll();

        List<String> names = new ArrayList<String>();

        for(User user : users){
            names.add(user.getUserName());
        }
        model.addAttribute("names", names);
        */
        return "home";
    }
}
