package perscholas.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.ProductDAO;
import perscholas.database.entity.Billing;
import perscholas.database.entity.Product;
import perscholas.database.entity.User;
import perscholas.service.BillingService;
import perscholas.service.ProductService;
import perscholas.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final BillingService billingService;
    private final UserService userService;
    private final ProductDAO productDAO;
    private final ProductService productService;
    @Autowired
    public UserController(UserService userService, BillingService billingService, ProductDAO productDAO, ProductService productService) {
        this.userService = userService;
        this.billingService = billingService;
        this.productDAO = productDAO;
        this.productService = productService;
    }


    // USER DETAILS //

    @GetMapping(value = "/user")
    public ModelAndView userHome(Principal principal) {
        ModelAndView page = new ModelAndView();
        String id = principal.getName();
        User user = userService.getUsername(id);
        Integer userid = user.getId();
        List<Billing> userCard = billingService.findByUserId(userid);
        List<Product> userProd = productDAO.findByCard_User_Id(userid);
        page.addObject("userCard", userCard);
        page.addObject("userProd", userProd);
        page.addObject("user", user);
        page.setViewName("user/home");
        LOGGER.trace("for tracing purpose");
        LOGGER.debug("for debugging purpose");
        LOGGER.info("for informational purpose");
        LOGGER.warn("for warning purpose");
        LOGGER.error("for logging errors");
        return page;
    }

    @RequestMapping(value = "user/edit", method = RequestMethod.GET)
    public ModelAndView editCustomerForm(Principal principal) {
        ModelAndView mav = new ModelAndView("user/details");
        String id = principal.getName();
        User user = userService.getUsername(id);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping(value = "user/editSave")
    public ModelAndView saveEditedUser(@ModelAttribute("user") User user, Principal principal) {
        ModelAndView response = new ModelAndView();
        String id = principal.getName();
        userService.getUsername(id);
        userService.save(user);
        response.setViewName("user/home");
        return response;
    }


    // EDIT PERSONAL CARD


    @RequestMapping(value = "user/editCard", method = RequestMethod.GET)
    public ModelAndView editUserCard(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("user/edit_card");
        Billing userCard = billingService.get(id);
        mav.addObject("userCard", userCard);
        return mav;
    }

    @PostMapping(value = "user/saveCard")
    public ModelAndView saveEditedUserCard(@ModelAttribute("userCard") Billing card) {
        ModelAndView response = new ModelAndView();
        billingService.save(card);
        response.setViewName("redirect:/user");
        return response;
    }

    // DELETE PERSONAL CARD
    @GetMapping("user/delete")
    public String cardDeleteConfirm(@RequestParam Integer id, Model model) {
        model.addAttribute("userCard", billingService.get(id));
        return "user/confirm_delete";
    }

    @RequestMapping(value = "user/delete/{id}", method = RequestMethod.POST)
    public String deleteCard(@PathVariable Integer id) {
        billingService.delete(id);
        return "redirect:/user";
    }

    // EDIT PERSONAL PRODUCTS

    @RequestMapping(value = "user/editProd", method = RequestMethod.GET)
    public ModelAndView editUserProd(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("user/edit_product");
        Product userProd = productService.get(id);
        mav.addObject("userProd", userProd);
        return mav;
    }

    @PostMapping(value = "user/saveProd")
    public ModelAndView saveEditedUserProd(@ModelAttribute("userProd") Product product) {
        ModelAndView response = new ModelAndView();
        productService.save(product);
        response.setViewName("redirect:/user");
        return response;
    }

    // DELETE PERSONAL CARD
    @GetMapping("user/cancel")
    public String prodCancelConfirm(@RequestParam Integer id, Model model) {
        model.addAttribute("userProd", productService.get(id));
        return "user/confirm_cancel";
    }

    @RequestMapping(value = "user/cancel/{id}", method = RequestMethod.POST)
    public String cancelProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/user";
    }

}
