package edu.nu.cs.web.controller;

import edu.nu.cs.security.SpringSecurityUtil;
import edu.nu.cs.service.interfaces.IUserService;
import edu.nu.cs.utils.UtilityClass;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by Hasnain on 11/26/14.
 */
@Controller
@RequestMapping("/secure")
public class AuthenticationController {

    @Resource
    IUserService userService;

    @Resource
    SpringSecurityUtil springSecurityUtil;

    @RequestMapping(value = "/login")
    private String login(ModelMap models){
        if(springSecurityUtil.isAuthenticated()){
            return "redirect:../home";
        }
        return "auth/login";
    }

    @RequestMapping(value = "/register")
    private String registerForm(ModelMap models){
        if(springSecurityUtil.isAuthenticated()){
            return "redirect:../home";
        }
        return "auth/register";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") @Valid UserVO user) {
        if(springSecurityUtil.isAuthenticated()){
            return "redirect:../home";
        }
        user.setPassword(UtilityClass.getMD5(user.getPassword()));
        userService.save(user);


        Authentication authentication = new UsernamePasswordAuthenticationToken( user.getUserName(), user.getPassword(), new ArrayList<GrantedAuthority>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UtilityClass.verifyUserDirectory(user.getUserName());

        return "redirect:../home";
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public @ResponseBody UserVO authenticateUser(String name, String password) {
        UserVO user = new UserVO();
        user.setUserName(name);
        user.setPassword(UtilityClass.getMD5(password));

        user = userService.findByUserNameAndPassword(user);

        if(user!=null){
            UtilityClass.verifyUserDirectory(user.getUserName());
        }
        return user;
    }

}
