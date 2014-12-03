package edu.nu.cs.web.controller;

import edu.nu.cs.converter.UserConverter;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.model.repo.UserRepository;
import edu.nu.cs.utils.UtilityClass;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm")UserVO user) {
        user.setPassword(UtilityClass.getMD5(user.getPassword()));
        userRepository.save((User) UserConverter.getInstance().convertToEntityBean(user));


        Authentication authentication = new UsernamePasswordAuthenticationToken( user.getUserName(), user.getPassword(), new ArrayList<GrantedAuthority>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:../home";
    }

}
