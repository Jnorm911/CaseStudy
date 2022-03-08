package perscholas.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {

    @GetMapping(value = { "/", "/index" })
    public ModelAndView index() {
        ModelAndView page = new ModelAndView();
        page.setViewName("index");
        return page;
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView page = new ModelAndView();
        page.setViewName("login/login");
        return page;
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView page = new ModelAndView();
        page.setViewName("register/register");
        return page;
    }

    @GetMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView page = new ModelAndView();
        page.setViewName("about");
        return page;
    }

}
