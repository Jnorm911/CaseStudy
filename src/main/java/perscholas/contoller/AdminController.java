package perscholas.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.entity.User;
import perscholas.database.form.AdminNewForm;
import perscholas.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(HttpServletRequest request, HttpSession session, Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/admin/admin");

        if ( id != null ) {
            // id has been passed to this form so it is an edit
            User user = adminService.get(id);
            // populate the form bean with the data loaded from the database
            AdminNewForm form = new AdminNewForm();
            form.setEmail(user.getEmail());
            form.setUsername(user.getUsername());
            // since we loaded this from the database we know the id field
            form.setId(user.getId());
            response.addObject("formBeanKey", form);
        } else {
            // an id has not been passed so it is a create
            // there is no data from the database so give an empty form bean
            AdminNewForm form = new AdminNewForm();
            response.addObject("formBeanKey", form);
        }
        return response;
    }

    // Create
    @PostMapping(value = "admin/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user, @Valid AdminNewForm form, BindingResult errors) {
        ModelAndView response = new ModelAndView();

        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                // add the error message to the errorMessages list in the form bean
                form.getErrorMessages().add(error.getDefaultMessage());
                LOG.debug("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("formBeanKey", form);
            response.setViewName("admin/admin");
        } else {
            adminService.save(user);
            response.addObject("user", user);
            response.setViewName("admin/new_user");
        }
        return response;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String redirectEverythingElse(){
        return "redirect:/admin";
    }

    @PostMapping(value = "admin/editSave")
    public ModelAndView saveEditedUser(@ModelAttribute("user") User user) {
        ModelAndView response = new ModelAndView();
        adminService.save(user);
        response.setViewName("admin/user_info");
        return response;
    }

    // Read
    @RequestMapping("admin/user_info")
    public ModelAndView userinfo() {
        List<User> list = adminService.listAll();
        return new ModelAndView("admin/user_info", "list", list);
    }

    // Read
    @RequestMapping("admin/new_user")
    public ModelAndView newUser() {
        List<User> list = adminService.listAll();
        return new ModelAndView("admin/new_user", "list", list);
    }

    // Update
    @RequestMapping(value = "admin/edit", method = RequestMethod.GET)
    public ModelAndView editCustomerForm(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("admin/edit_user");
        User user = adminService.get(id);
        mav.addObject("user", user);
        return mav;
    }

    // Delete
    @GetMapping("admin/users/delete")
    public String getUserForm(@RequestParam Integer id, Model model) {
        model.addAttribute("user", adminService.get(id));
        return "admin/confirm_delete";
    }

    @RequestMapping(value = "admin/users/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Integer id) {
        adminService.delete(id);
        return "redirect:/admin";
    }

    // Search
    @RequestMapping("admin/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<User> result = adminService.search(keyword);
        ModelAndView page = new ModelAndView("admin/search");
        page.addObject("result", result);
        return page;
    }
}
