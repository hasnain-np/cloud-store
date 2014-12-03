package edu.nu.cs.web.controller;

        import edu.nu.cs.model.entity.User;
        import edu.nu.cs.model.repo.UserRepository;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.annotation.Resource;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Hasnain on 11/26/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserRepository userRepository;

    @RequestMapping("/greeting/{name}")
    private String greeting(@PathVariable(value = "name") String name){
        return "Hello! " + name;
    }

    @RequestMapping
    public String printHello(ModelMap model) {
        model.addAttribute("name", "Talha !");

        List<User> users = userRepository.findAll();

        List<String> names = new ArrayList<String>();

        for(User user : users){
            names.add(user.getUserName());
        }
        model.addAttribute("names", names);

        return "test";
    }
}
