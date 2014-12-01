package edu.nu.cs.web.controller;

import edu.nu.cs.converter.UserConverter;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.model.repo.UserRepository;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    @RequestMapping(value = "/submitRegister")
    private String saveRegisterForm(ModelMap models) {

        return "redirect:../home";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("userForm")UserVO user, ModelMap model) {
        userRepository.save((User) UserConverter.getInstance().convertToEntityBean(user));

        return "result";
    }

}
