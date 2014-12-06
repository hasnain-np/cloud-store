package edu.nu.cs.web.controller;

import edu.nu.cs.security.SpringSecurityUtil;
import edu.nu.cs.utils.UtilityClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasnain on 12/1/2014.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Resource
    SpringSecurityUtil springSecurityUtil;

    @RequestMapping(value={"/", "/home"})
    public String home(ModelMap model) {
        List<String> files = new ArrayList<String>();
        List<String> folders = new ArrayList<String>();

        UtilityClass.loadFilesAndFolders(files, folders, UtilityClass.getBaseDirectory() + "\\" + springSecurityUtil.getLoginUserName());

        model.addAttribute("folders", folders);
        model.addAttribute("files", files);

        return "home";
    }

}
