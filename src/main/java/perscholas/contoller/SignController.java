package perscholas.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.entity.User;
import perscholas.service.AdminService;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/register")
public class SignController {

    private final AdminService userService;

    @Autowired
    public SignController(AdminService userService) {
        this.userService = userService;
    }

    // Create
    @PostMapping(value = "save_user")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        if(Objects.equals(user.getConfirmPassword(), user.getPassword())){
            userService.save(user);
            return new ModelAndView("register/user_info");
        } else {
            return new ModelAndView("register/register");
        }
    }

    // Read
    @RequestMapping("/user_info")
    public ModelAndView userinfo() {
        List<User> list = userService.listAll();
        return new ModelAndView("register/user_info", "list", list);
    }


}
